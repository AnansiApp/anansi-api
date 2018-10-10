package br.com.anansi.repository;

import br.com.anansi.model.Specie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecieRepository extends CrudRepository <Specie, String> {

    List<Specie> findAll();

    @Query(value = "SELECT UNIQUE c.specie from SpecieCharacteristic c where c.characteristic.id in :characteristics")
    List<Specie> findByCharacteristics(@Param("characteristics") List<Long> characteristics);

}
