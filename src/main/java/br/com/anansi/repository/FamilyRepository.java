package br.com.anansi.repository;

import br.com.anansi.model.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends CrudRepository <Family, String> {

    List<Family> findAllByOrderByName();

    @Query(value = "SELECT distinct c.family from FamilyCharacteristic c where c.characteristic.id in :characteristics group by c.family.id having count (c.family) = :numFilters")
    List<Family> findByCharacteristics(@Param("characteristics") List<Long> characteristics, @Param("numFilters") Long numFilters);

    List<Family> findByPopularNameContainingIgnoreCaseOrNameContainingIgnoreCaseOrderByName(String popularName, String name);

}
