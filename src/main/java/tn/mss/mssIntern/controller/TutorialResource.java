package tn.mss.mssIntern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.mss.mssIntern.modele.Tutorial;
import tn.mss.mssIntern.service.TutorialService;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
public class TutorialResource {
    @Autowired
    TutorialService tutorialService;
    @GetMapping("/all")
    public ResponseEntity<List<Tutorial>> getAllTutorials (){
        List<Tutorial> tutorials = tutorialService.findAllTutorials();
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Tutorial> getAllTutorials (@PathVariable("id")Long id ){
       Tutorial tutorial = tutorialService.findTutorialById(id);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }
    @GetMapping("/entities/{name}")
    public ResponseEntity <List<Tutorial>> getTutorialByName(@PathVariable("name") String name) {
        List<Tutorial> tutorial = tutorialService.findTutorialByName(name);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
        System.out.println("tutorial is"+tutorial);
        Tutorial newtutorial = tutorialService.addTutorial(tutorial);
        return new ResponseEntity<>(newtutorial,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial){

        Tutorial updateTutorial=tutorialService.updateTutorial(tutorial);
        return new ResponseEntity<>(updateTutorial,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTutorialRepo(@PathVariable("id") Long id){
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
