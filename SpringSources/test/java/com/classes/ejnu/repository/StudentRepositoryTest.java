package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void saveTest() {
        Student student = new Student();
        student.setStudentId(1001190101);
        student.setStudentName("尤夏");
        student.setStudentPassword("endro1");
        student.setMajorId(1);

        Student result = repository.save(student);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByMajorId() {
        List<Student> studentList = repository.findByMajorId(1);
        Assert.assertNotEquals(0, studentList.size());
    }
}