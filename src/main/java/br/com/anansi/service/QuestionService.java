package br.com.anansi.service;

import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Question;
import br.com.anansi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question getFirstQuestion(){
        return questionRepository.findFirst();
    }

    public List<CharacteristicQuestion> getOptions(Long question){
        return questionRepository.findOptionsQuestion(question);
    }

    public Question getNextQuestion(Long idCurrent, Long idOption){
        return questionRepository.findNextQuestion(idCurrent, idOption);
    }

    public Question getNextQuestion(List<Long> questions){
        Question question = questionRepository.findFirstByFirstAndIdNotIn(true, questions);
        if(question == null){
            question = questionRepository.findFirstByIdNotIn(questions);
        }
        return question;
    }
}
