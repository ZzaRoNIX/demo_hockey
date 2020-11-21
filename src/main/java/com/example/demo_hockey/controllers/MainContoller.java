package com.example.demo_hockey.controllers;

import com.example.demo_hockey.entity.AllTrainerInfo;
import com.example.demo_hockey.repository.TrainerCardRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

// маршутиризатор
@RestController
public class MainContoller {

    @Autowired
    TrainerCardRepository trainerCardRepository;
// создание
    @PostMapping("/create")
    public void create(@RequestParam String fullName, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date bornDate, @RequestParam String education,
                       @RequestParam String profCareer, @RequestParam String workExperience, @RequestParam String description) {
        val a = AllTrainerInfo.builder().fullName(fullName).bornDate(bornDate).education(education).profCareer(profCareer).workExperience(workExperience)
                .description(description).build();
        val b = trainerCardRepository.save(a);
    }
//поиск информации по имени
    @ResponseBody
    @GetMapping("/card")
    public ResponseEntity<String> findCard(@RequestParam String fullName) {
        Gson gson = new GsonBuilder().create();
        String findCard = gson.toJson(trainerCardRepository.findByFullName(fullName));
        return new ResponseEntity<String>(findCard, HttpStatus.OK);

    }
    // получение имен всех тренеров
    @ResponseBody
    @PostMapping("/card/allname")
    public ResponseEntity<String> findName() {
        ArrayList<String> allFulname = new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        val allInfo = trainerCardRepository.findAll();
        for (int i = 0; allInfo.size() > i; i++) {
            allFulname.add(allInfo.get(i).getFullName());
        }
        String findFullName = gson.toJson(allFulname);
        return new ResponseEntity<String>(findFullName, HttpStatus.OK);
        // return findCard.get().getFullName();
    }


}
