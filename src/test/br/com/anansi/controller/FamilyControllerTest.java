package br.com.anansi.controller;

import br.com.anansi.MainController;
import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Family;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = MainController.class)
public class FamilyControllerTest {

    @Autowired
    private FamilyController familyController;

    @Test
    public void getFamilies() {
        Assert.assertTrue(!familyController.getFamilies().getBody().isEmpty());
    }

    @Test
    public void getFamiliesOptions() {
        List<Long> characteristicsIds = new ArrayList<>();
        characteristicsIds.add(new Long(3));
        List<Family> families = familyController.getFamiliesOptions(characteristicsIds).getBody();
        for (Family family :
                families) {
            System.out.println(family.getName());
            if(family.getName().equals("Theraphosidae")){
                Assert.assertTrue(true);
         }
        }
    }

    @Test
    public void getFamiliesByName() {
        List<Family> families = familyController.getFamiliesByName("Ly").getBody();
        for (Family family :
                families) {
            System.out.println(family.getName());
            if(family.getName().equals("Lycosidae")){
                Assert.assertTrue(true);
            }
        }

    }
}