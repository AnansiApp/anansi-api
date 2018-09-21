package br.com.anansi.service;

import br.com.anansi.model.Specie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpiderService {

    public List<Specie> findAllSpecies(){

        List<Specie> species = new ArrayList<>();
        species.add(new Specie("Lycosa", "Cerrado", false));
        species.add(new Specie("Argiope", "Cerrado", false));
        species.add(new Specie("Caranguegeira", "Cerrado", false));
        species.add(new Specie("Cyrtophora", "Cerrado", false));

        return species;
    }

}
