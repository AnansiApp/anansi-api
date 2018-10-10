package br.com.anansi.controller;

import br.com.anansi.model.CharacteristicQuestion;
import br.com.anansi.model.Specie;
import br.com.anansi.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpiderController {

    @Autowired
    private SpiderService service;

    @RequestMapping(value = "/species", method = RequestMethod.GET)
    public ResponseEntity<List<Specie>> getSpecies(){
        return new ResponseEntity<>(service.findAllSpecies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/characteristics", method = RequestMethod.GET)
    public ResponseEntity<List<Specie>> getSpeciesOptions(@RequestParam("id") List<Long> characteristcs){
        return new ResponseEntity<>(service.findResult(characteristcs), HttpStatus.OK);
    }

}
