package br.com.anansi.controller;

import br.com.anansi.model.Family;
import br.com.anansi.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping(value = "/api/spider")
public class FamilyController {

    @Autowired
    private SpiderService service;

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/families", method = RequestMethod.GET)
    public ResponseEntity<List<Family>> getFamilies(){
        return new ResponseEntity<>(service.findAllFamilies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/characteristics", method = RequestMethod.GET)
    public ResponseEntity<List<Family>> getFamiliesOptions(@RequestParam(value = "id", required=false) List<Long> characteristcs){
        return new ResponseEntity<>(service.findResult(characteristcs), HttpStatus.OK);
    }

    @RequestMapping(value = "/families/get", method = RequestMethod.GET)
    public ResponseEntity<List<Family>> getFamiliesByName(@RequestParam("name") String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

}
