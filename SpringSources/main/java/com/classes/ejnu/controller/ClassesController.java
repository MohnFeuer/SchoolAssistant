package com.classes.ejnu.controller;

import com.classes.ejnu.dataobject.Classes;
import com.classes.ejnu.dataobject.Major;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.ClassesService;
import com.classes.ejnu.service.MajorService;
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
@RequestMapping("office/classes")
@Slf4j
public class ClassesController {
    
    @Autowired
    private MajorService majorService;

    /*课程*/
    @Autowired
    private ClassesService classesService;

    /**
     * 课程列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return classes/list
     */
    @GetMapping("/list")
    public ModelAndView classeslist(@RequestParam(value = "majorId", required = false) Integer majorId,
                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String, Object> map){
        Pageable pageable = PageRequest.of(page - 1, size);

        List<Classes> classesList;
        if(majorId != null)
            classesList = classesService.findAllByMajorId(majorId);
        else
            classesList = classesService.findAll();

        Page<Classes> classesPage = new PageImpl<Classes>(classesList, pageable, classesList.size());

        Major major = majorService.findOne(majorId);

        map.put("major", major);
        map.put("classesPage", classesPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("classes/list", map);
    }

    /**
     * 删除课程
     * @param classesId 课程号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView classesdelete(@RequestParam("classesId") Integer classesId,
                                      Map<String, Object> map){
        Integer majorId = classesService.findOne(classesId).getMajorId();
        classesService.delete(classesId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/classes/list?majorId="+majorId);
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView classesdetail(@RequestParam(value = "majorId", required = false) Integer majorId,
                                      @RequestParam(value = "classesId", required = false) Integer classesId,
                                      Map<String, Object> map) {

        Classes classes = new Classes();

        //classesId不为空，是修改操作
        if (classesId != null)
            classes = classesService.findOne(classesId);

        //majorId不为空，是新增操作

        map.put("majorId", majorId);
        map.put("classes", classes);
        return new ModelAndView("classes/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView classessave(@Valid Classes classes,
                                    BindingResult bindingResult,
                                    Map<String, Object> map) {

        Integer majorId = classes.getMajorId();

        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/classes/list?majorId="+majorId);
            return new ModelAndView("common/error", map);
        }

        classesService.save(classes);

        map.put("url", "/ejnu/office/classes/list?majorId="+majorId);
        return new ModelAndView("common/success", map);
    }
}
