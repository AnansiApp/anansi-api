package br.com.anansi.service;

import br.com.anansi.model.Family;
import br.com.anansi.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpiderService {

    @Autowired
    private FamilyRepository familyRepository;

    public List<Family> findAllFamilies(){
        return familyRepository.findAllByOrderByName();
    }

    public List<Family> findResult(List<Long> characteristics){
        return familyRepository.findByCharacteristics(characteristics, new Long(characteristics.size()));
    }

    public List<Family> findByName(String name){
        return familyRepository.findByNameIgnoreCaseContainingOrderByName(name);
    }

}
