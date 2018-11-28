package br.com.anansi.controller;

import br.com.anansi.model.Specie;
import br.com.anansi.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping(value = "/api/spider")
public class SpiderController {

    @Autowired
    private SpiderService service;

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/species", method = RequestMethod.GET)
    public ResponseEntity<List<Specie>> getSpecies(){
        return new ResponseEntity<>(service.findAllSpecies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/characteristics", method = RequestMethod.GET)
    public ResponseEntity<List<Specie>> getSpeciesOptions(@RequestParam("id") List<Long> characteristcs){
        return new ResponseEntity<>(service.findResult(characteristcs), HttpStatus.OK);
    }

    @RequestMapping(value = "/species/get", method = RequestMethod.GET)
    public ResponseEntity<List<Specie>> getSpeciesByName(@RequestParam("name") String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

}
