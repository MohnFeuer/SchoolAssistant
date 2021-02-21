package com.classes.ejnu.controller;

import com.classes.ejnu.dataobject.Homework;
import com.classes.ejnu.dataobject.Speclass;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.HomeworkService;
import com.classes.ejnu.service.SpeclassService;
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
@RequestMapping("office/homework")
@Slf4j
public class HomeworkController {
    

    @Autowired
    private SpeclassService speclassService;

    /*作业*/
    @Autowired
    private HomeworkService homeworkService;

    /**
     * 作业列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return homework/list
     */
    @GetMapping("/list")
    public ModelAndView homeworklist(@RequestParam(value = "speclassId", required = false) Integer speclassId,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     Map<String, Object> map){
        Pageable pageable = PageRequest.of(page - 1, size);

        //具体课程列表
        List<Homework> homeworkList;
        if(speclassId != null)
            homeworkList = homeworkService.findAllBySpeclassId(speclassId);
        else
            homeworkList = homeworkService.findAll();

        Page<Homework> homeworkPage = new PageImpl<Homework>(homeworkList, pageable, homeworkList.size());

        Speclass speclass = speclassService.findOne(speclassId);

        map.put("speclass", speclass);
        map.put("homeworkPage", homeworkPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("homework/list", map);
    }

    /**
     * 删除作业
     * @param homeworkId 作业号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView homeworkdelete(@RequestParam("homeworkId") Integer homeworkId,
                                       Map<String, Object> map){
        Integer speclassId = homeworkService.findOne(homeworkId).getSpeclassId();
        homeworkService.delete(homeworkId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/homework/list?speclassId="+speclassId);
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView homeworkdetail(@RequestParam(value = "speclassId", required = false) Integer speclassId,
                                       @RequestParam(value = "homeworkId", required = false) Integer homeworkId,
                                       Map<String, Object> map) {

        Homework homework = new Homework();

        //homeworkId不为空，是修改操作
        if (homeworkId != null)
            homework = homeworkService.findOne(homeworkId);

        //speclassId不为空，是新增操作

        map.put("speclassId", speclassId);
        map.put("homework", homework);
        return new ModelAndView("homework/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView homeworksave(@Valid Homework homework,
                                     BindingResult bindingResult,
                                     Map<String, Object> map) {

        Integer speclassId = homework.getSpeclassId();

        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/homework/list?speclassId="+speclassId);
            return new ModelAndView("common/error", map);
        }

        homeworkService.save(homework);

        map.put("url", "/ejnu/office/homework/list?speclassId="+speclassId);
        return new ModelAndView("common/success", map);
    }

}
