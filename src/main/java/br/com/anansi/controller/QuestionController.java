package br.com.anansi.controller;

import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Question;
import br.com.anansi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @RequestMapping(value = "/first_question", method = RequestMethod.GET)
    public ResponseEntity<Question> getFirstQuestion(){
        return new ResponseEntity<>(service.getFirstQuestion(), HttpStatus.OK);
    }

    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public ResponseEntity<List<CharacteristicQuestion>> getOptions(@RequestParam("questionId") long questionId){
        return new ResponseEntity<>(service.getOptions(questionId), HttpStatus.OK);
    }

    @RequestMapping(value = "/next_question", method = RequestMethod.GET)
    public ResponseEntity<Question> getNextQuestion (@RequestParam("idCurrentQuestion") long idCurrentQuestion,
                                                     @RequestParam(value = "idOption", required=false) Long idOption,
                                                     @RequestParam(value = "idCharacteristics", required=false) List<Long> characteristics,
                                                     @RequestParam("idQuestions") List<Long> questions){
        return new ResponseEntity<>(service.getNextQuestion(idCurrentQuestion, idOption, questions, characteristics), HttpStatus.OK);
    }

}
