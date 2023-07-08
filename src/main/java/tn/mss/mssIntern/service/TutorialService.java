package tn.mss.mssIntern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.mss.mssIntern.modele.Tutorial;
import tn.mss.mssIntern.repositories.TutorialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TutorialService {
    @Autowired(required=true)
    public  TutorialRepository tutorialRepo;
    public Tutorial addTutorial(Tutorial tutorial) {
        System.out.println(tutorial);
        return tutorialRepo.save(tutorial);
    }
    public List<Tutorial> findAllTutorials(){
        List<Tutorial> list=new ArrayList<>();
        for (Tutorial tut : tutorialRepo.findAll()) {
            list.add(tut);
        }
        return list;
    }
    public Tutorial updateTutorial(Tutorial tutorial){

        return tutorialRepo.save(tutorial);
    }
    public List<Tutorial> findTutorialByName(String name) {
        return tutorialRepo.findAllByName2(name);
    }
    public Tutorial findTutorialById(Long id){

        return tutorialRepo.findById(id).orElse(null);
    }
    public void deleteTutorial(Long id){
        tutorialRepo.deleteById(id);

    }
}

