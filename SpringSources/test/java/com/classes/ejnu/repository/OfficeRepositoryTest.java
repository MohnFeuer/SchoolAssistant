package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Office;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeRepositoryTest {

    @Autowired
    private OfficeRepository repository;

    @Test
    public void findOneTest() {
        Office office = repository.findById("rona").orElse(null);
        assert office != null;
        System.out.println(office.toString());
    }

    @Test
    public void saveTest() {
        Office office = new Office();
        office.setOfficeId("rona");
        office.setOfficePassword("endro2020");
        repository.save(office);
    }
}