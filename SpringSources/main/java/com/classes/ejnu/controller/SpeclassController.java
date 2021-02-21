package com.classes.ejnu.controller;


import com.classes.ejnu.dataobject.Classes;
import com.classes.ejnu.dataobject.Speclass;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.ClassesService;
import com.classes.ejnu.service.SpeclassService;
import com.classes.ejnu.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("office/speclass")
@Slf4j
public class SpeclassController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassesService classesService;

    /*课程*/
    @Autowired
    private SpeclassService speclassService;

    /**
     * 课程列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return speclass/list
     */
    @GetMapping("/list")
    public ModelAndView speclasslist(@RequestParam(value = "classesId", required = false) Integer classesId,
                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String, Object> map){
        Pageable pageable = PageRequest.of(page - 1, size);

        //具体课程列表
        List<Speclass> speclassList;
        if(classesId != null)
            speclassList = speclassService.findAllByClassesId(classesId);
        else
            speclassList = speclassService.findAll();

        Page<Speclass> speclassPage = new PageImpl<Speclass>(speclassList, pageable, speclassList.size());

        Classes classes = classesService.findOne(classesId);

        map.put("classes", classes);
        map.put("speclassPage", speclassPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("speclass/list", map);
    }

    /**
     * 删除课程
     * @param speclassId 课程号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView speclassdelete(@RequestParam("speclassId") Integer speclassId,
                                      Map<String, Object> map){
        Integer classesId = speclassService.findOne(speclassId).getClassesId();
        speclassService.delete(speclassId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/speclass/list?classesId="+classesId);
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView speclassdetail(@RequestParam(value = "classesId", required = false) Integer classesId,
                                      @RequestParam(value = "speclassId", required = false) Integer speclassId,
                                      Map<String, Object> map) {

        Speclass speclass = new Speclass();

        //speclassId不为空，是修改操作
        if (speclassId != null)
            speclass = speclassService.findOne(speclassId);

        //classesId不为空，是新增操作

        map.put("classesId", classesId);
        map.put("speclass", speclass);
        return new ModelAndView("speclass/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView speclasssave(@Valid Speclass speclass,
                                    BindingResult bindingResult,
                                    Map<String, Object> map) {

        Integer classesId = speclass.getClassesId();

        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/speclass/list?classesId="+classesId);
            return new ModelAndView("common/error", map);
        }

        speclassService.save(speclass);

        map.put("url", "/ejnu/office/speclass/list?classesId="+classesId);
        return new ModelAndView("common/success", map);
    }
}
