package br.com.anansi.controller;

import br.com.anansi.MainController;
import br.com.anansi.model.CharacteristicQuestion;
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
public class QuestionControllerTest {

    @Autowired
    QuestionController questionController;

    @Test
    public void getFirstQuestion() {

        Question question = questionController.getFirstQuestion().getBody();

        Assert.assertEquals(question.getContent(),"Em que ambiente foi avistada?");

    }

    @Test
    public void getOptions() {
        
        List<CharacteristicQuestion> options = questionController.getOptions(new Long(1)).getBody();

        for (CharacteristicQuestion option :
                options) {
            if (option.getDescription().equals("Ambiente Urbano (quintal, parques, etc)")){
                Assert.assertTrue(true);
            }
        }
        
    }

    @Test
    public void getNextQuestion() {
        Question nextQuestion = questionController.getNextQuestion(new Long(1), new Long(2), new ArrayList<Long>(), new ArrayList<Long>()).getBody();
        Assert.assertEquals(nextQuestion.getContent(), "Onde foi avistada?");

    }
}