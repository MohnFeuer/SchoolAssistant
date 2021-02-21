package com.classes.ejnu.controller;

import com.classes.ejnu.dataobject.Major;
import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.MajorService;
import com.classes.ejnu.service.StudentService;
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
@RequestMapping("office/student")
@Slf4j
public class StudentController {

    @Autowired
    private MajorService majorService;

    /*学生*/
    @Autowired
    private StudentService studentService;

    /**
     * 学生列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return student/list
     */
    @GetMapping("/list")
    public ModelAndView studentlist(@RequestParam(value = "majorId", required = false) Integer majorId,
                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String, Object> map){
        Pageable pageable = PageRequest.of(page - 1, size);
        List<Student> studentList = studentService.findAllByMajorId(majorId);

        Page<Student> studentPage = new PageImpl<Student>(studentList, pageable, studentList.size());

        Major major = majorService.findOne(majorId);

        map.put("major", major);
        map.put("studentPage", studentPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("student/list", map);
    }

    /**
     * 删除学生
     * @param studentId 专业号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView studentdelete(@RequestParam("studentId") Integer studentId,
                                    Map<String, Object> map){
        Integer majorId = studentService.findOne(studentId).getMajorId();
        studentService.delete(studentId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/student/list?majorId="+majorId);
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView studentdetail(@RequestParam(value = "majorId", required = false) Integer majorId,
                                    @RequestParam(value = "studentId", required = false) Integer studentId,
                                    Map<String, Object> map) {

        Student student = new Student();

        //studentId不为空，是修改操作
        if (studentId != null)
            student = studentService.findOne(studentId);

        //majorId不为空，是新增操作

        map.put("majorId", majorId);
        map.put("student", student);
        return new ModelAndView("student/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView studentsave(@Valid Student student,
                                  BindingResult bindingResult,
                                  Map<String, Object> map) {

        Integer majorId = student.getMajorId();

        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/student/list?majorId="+majorId);
            return new ModelAndView("common/error", map);
        }

        studentService.save(student);

        map.put("url", "/ejnu/office/student/list?majorId="+majorId);
        return new ModelAndView("common/success", map);
    }
}
