package br.com.anansi.service;

import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Family;
import br.com.anansi.model.Question;
import br.com.anansi.repository.FamilyRepository;
import br.com.anansi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FamilyRepository familyRepository;

    public Question getFirstQuestion(){
        return questionRepository.findFirst();
    }

    public List<CharacteristicQuestion> getOptions(Long question){
        return questionRepository.findOptionsQuestion(question);
    }

    public Question getNextQuestion(Long idCurrent, Long idOption, List<Long> questions, List<Long> characteristics){

        Question nextQuestion;

        if(idOption == null){
            nextQuestion = getNextRandomQuestion(questions);
        } else{
            nextQuestion = questionRepository.findNextQuestion(idCurrent, idOption);
        }

        if(nextQuestion == null){
            return null;
        }

        nextQuestion.getOptions().removeAll(getOptionsToRemove(nextQuestion, characteristics));

        if(nextQuestion.getOptions().size() == 0){
            questions.add(nextQuestion.getId());
            getNextQuestion(null, null, questions, characteristics);
        }

        return nextQuestion;
    }

    private List<CharacteristicQuestion> getOptionsToRemove(Question nextQuestion, List<Long> characteristics){

        List<Long> possibleIdOptions = new ArrayList<>();
        List<CharacteristicQuestion> optionsToRemove = new ArrayList<>();

        if (characteristics != null) {
            possibleIdOptions.addAll(characteristics);
        }

        for (CharacteristicQuestion option :
                nextQuestion.getOptions()) {
            possibleIdOptions.add(option.getId());
            List<Family> results = familyRepository.findByCharacteristics(possibleIdOptions, new Long(possibleIdOptions.size()));
            if(results == null || results.size() == 0){
                optionsToRemove.add(option);
            }
            possibleIdOptions.remove(option.getId());
        }

        return optionsToRemove;

    }

    public Question getNextRandomQuestion(List<Long> questions){
        Question question = questionRepository.findFirstByFirstAndIdNotIn(true, questions);
        if(question == null){
            question = questionRepository.findFirstByIdNotIn(questions);
        }
        return question;
    }
}
