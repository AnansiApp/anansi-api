package br.com.anansi.service;

import br.com.anansi.MainController;
import br.com.anansi.model.Family;
import br.com.anansi.model.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = MainController.class)
public class SpiderServiceTest {

    @Autowired
    SpiderService spiderService;

    @Test
    public void findAllFamilies() {

        Assert.assertTrue(!spiderService.findAllFamilies().isEmpty());;

    }

    @Test
    public void findResult() {

        List<Long> characteristics = new ArrayList<>();
        characteristics.add(new Long(1));
        List<Family> families = spiderService.findResult(characteristics);
        for (Family family :
                families) {
            System.out.println(family.getName());
            if(family.getName().equals("Theraphosidae")){
                Assert.assertTrue(true);
            }
        }
    }

    @Test
    public void findByName() {

        List<Family> families = spiderService.findByName("Ly");
        for (Family family :
                families) {
            System.out.println(family.getName());
            if(family.getName().equals("Lycosidae")){
                Assert.assertTrue(true);
            }
        }
    }
}