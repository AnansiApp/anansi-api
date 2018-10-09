package br.com.anansi.service;

import br.com.anansi.model.Specie;
import br.com.anansi.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SpiderService {

    @Autowired
    private SpecieRepository specieRepository;

    public List<Specie> findAllSpecies(){

        return specieRepository.findAll();
    }

}
