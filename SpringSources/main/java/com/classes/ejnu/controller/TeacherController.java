package com.classes.ejnu.controller;


import com.classes.ejnu.dataobject.Major;
import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.dataobject.Teacher;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.MajorService;
import com.classes.ejnu.service.StudentService;
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
@RequestMapping("office/teacher")
@Slf4j
public class TeacherController {


    @Autowired
    private MajorService majorService;

    /*教师*/
    @Autowired
    private TeacherService teacherService;

    /**
     * j教师列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return student/list
     */
    @GetMapping("/list")
    public ModelAndView teacherlist(@RequestParam(value = "majorId", required = false) Integer majorId,
                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String, Object> map){
        Pageable pageable = PageRequest.of(page - 1, size);

        List<Teacher> teacherList;
        if(majorId != null)
            teacherList = teacherService.findAllByMajorId(majorId);
        else
            teacherList = teacherService.findAll();

        Page<Teacher> teacherPage = new PageImpl<Teacher>(teacherList, pageable, teacherList.size());

        Major major = majorService.findOne(majorId);

        map.put("major", major);
        map.put("teacherPage", teacherPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("teacher/list", map);
    }

    /**
     * 删除教师
     * @param teacherId 教师号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView teacherdelete(@RequestParam("teacherId") Integer teacherId,
                                      Map<String, Object> map){
        Integer majorId = teacherService.findOne(teacherId).getMajorId();
        teacherService.delete(teacherId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/teacher/list?majorId="+majorId);
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView teacherdetail(@RequestParam(value = "majorId", required = false) Integer majorId,
                                      @RequestParam(value = "teacherId", required = false) Integer teacherId,
                                      Map<String, Object> map) {

        Teacher teacher = new Teacher();

        //teacherId不为空，是修改操作
        if (teacherId != null)
            teacher = teacherService.findOne(teacherId);

        //majorId不为空，是新增操作

        map.put("majorId", majorId);
        map.put("teacher", teacher);
        return new ModelAndView("teacher/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView teachersave(@Valid Teacher teacher,
                                    BindingResult bindingResult,
                                    Map<String, Object> map) {

        Integer majorId = teacher.getMajorId();

        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/teacher/list?majorId="+majorId);
            return new ModelAndView("common/error", map);
        }

        teacherService.save(teacher);

        map.put("url", "/ejnu/office/teacher/list?majorId="+majorId);
        return new ModelAndView("common/success", map);
    }

}
