package br.com.anansi.controller;

import br.com.anansi.model.Specie;
import br.com.anansi.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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
