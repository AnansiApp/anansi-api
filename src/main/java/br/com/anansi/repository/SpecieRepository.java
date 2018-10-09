package br.com.anansi.repository;

import br.com.anansi.model.Specie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecieRepository extends CrudRepository <Specie, String> {

    List<Specie> findAll();

}
