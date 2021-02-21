package com.classes.ejnu.usercontroller;

import com.classes.ejnu.VO.ResultVO;
import com.classes.ejnu.dataobject.Homework;
import com.classes.ejnu.dataobject.Speclass;
import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.dataobject.Teacher;
import com.classes.ejnu.service.HomeworkService;
import com.classes.ejnu.service.SpeclassService;
import com.classes.ejnu.service.StudentService;
import com.classes.ejnu.service.TeacherService;
import com.classes.ejnu.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/student")
public class StudentSpeclassController {

    @Autowired
    private SpeclassService speclassService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/speclass")
    public ResultVO speclass(@RequestParam("studentId") Integer studentId) {

        List<Speclass> speclassList = new ArrayList<>();
        speclassList = speclassService.findAllByStudentId(studentId);

        return ResultVoUtil.success(speclassList);
    }

    @PostMapping("/homework")
    public ResultVO homework(@RequestParam("speclassId") Integer speclassId) {

        List<Homework> homeworkList = new ArrayList<>();
        homeworkList = homeworkService.findAllBySpeclassId(speclassId);

        return ResultVoUtil.success(homeworkList);
    }

    @PostMapping("/speclass/teacher")
    public ResultVO speTeacher(@RequestParam("teacherId") Integer teacherId) {

        Teacher teacher = teacherService.findOne(teacherId);
        return ResultVoUtil.success(teacher.getTeacherName());
    }
}
