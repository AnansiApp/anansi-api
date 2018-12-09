package br.com.anansi.service;

import br.com.anansi.MainController;
import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Question;
import br.com.anansi.repository.QuestionRepository;
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
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void getFirstQuestion() {

        Question firstQuestion = questionService.getFirstQuestion();
        Assert.assertEquals(firstQuestion.getContent(), "Em que ambiente foi avistada?");
        Assert.assertEquals(firstQuestion.getId(), new Long(1));
        Assert.assertTrue(firstQuestion.getFirst());

    }

    @Test
    public void getOptions() {

        List<CharacteristicQuestion> optionsResponse = questionService.getOptions(new Long(1));
        Assert.assertTrue(optionsResponse.get(0).getDescription().equals("Ambiente Urbano (quintal, parques, etc)"));

    }

    @Test
    public void getNextQuestion() {
        Question nextQuestion = questionService.getNextQuestion(new Long(1), new Long(2), new ArrayList<Long>(), new ArrayList<Long>());
        Assert.assertEquals(nextQuestion.getContent(), "Onde foi avistada?");

    }

    @Test
    public void getNextRandomQuestion() {
        List<Long> questions = new ArrayList<>();
        questions.add(new Long(1));
        Question nextRandomQuestion = questionService.getNextRandomQuestion(questions);
        Assert.assertEquals(nextRandomQuestion.getId(), new Long(2));
    }
}