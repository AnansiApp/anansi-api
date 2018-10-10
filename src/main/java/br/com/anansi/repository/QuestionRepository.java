package br.com.anansi.repository;

import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {

    List<Question> findAll();

    @Query(value = "SELECT q FROM Question q WHERE q.first = true")
    Question findFirst();

    @Query(value = "SELECT o FROM CharacteristicQuestion o WHERE o.question.id = :question")
    List<CharacteristicQuestion> findOptionsQuestion(@Param("question") Long question);

    @Query(value = "SELECT n.nextQuestion FROM NextQuestion n where n.currentQuestion.id = :idCurrent and n.response.id = :idOption")
    Question findNextQuestion(@Param("idCurrent") Long idCurrent, @Param("idOption") Long idOption);

}
