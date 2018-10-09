package br.com.anansi.repository;

import br.com.anansi.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {

    List<Question> findAll();



}
