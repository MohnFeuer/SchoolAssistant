package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Major;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MajorRepositoryTest {

    @Autowired
    private MajorRepository repository;

    @Test
    public void saveTest() {
        Major major = new Major();
        major.setMajorName("计算机科学与技术");
        Major result = repository.save(major);
        Assert.assertNotNull(result);
    }

}