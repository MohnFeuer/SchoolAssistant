package com.classes.ejnu.usercontroller;


import com.classes.ejnu.VO.ResultVO;
import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.service.StudentService;
import com.classes.ejnu.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/student")
public class StudentUserController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/login")
    public ResultVO login(@RequestParam("studentId") String studentId,
                          @RequestParam("studentPassword") String studentPassword) {

        Student student = studentService.findOne(Integer.parseInt(studentId));

        if(student == null || !studentPassword.equals(student.getStudentPassword()))
        {
            return ResultVoUtil.error(1,"密码错误或用户名不存在");
        }

        return ResultVoUtil.success(student);
    }



}
