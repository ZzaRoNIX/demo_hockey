package com.example.demo_hockey.controller;

import com.example.demo_hockey.entity.Arena;
import com.example.demo_hockey.entity.Trainer;
import com.example.demo_hockey.repository.ArenasInfoRepository;
import com.example.demo_hockey.repository.TrainerCardRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

// маршутиризатор
@RestController
public class MainController {

    private static final Gson gson = new GsonBuilder().create();

    final TrainerCardRepository trainerCardRepository;
    final ArenasInfoRepository arenasInfoRepository;


    public MainController(TrainerCardRepository trainerCardRepository, ArenasInfoRepository arenasInfoRepository) {
        this.trainerCardRepository = trainerCardRepository;
        this.arenasInfoRepository = arenasInfoRepository;

    }

    // создание карты тренера
    @PostMapping("/trainerCard/create")
    public void createTrainerCard(@RequestBody Trainer trainer) {
        trainerCardRepository.save(trainer);
    }

    //поиск информации по имени
    @ApiResponse(responseCode = "200", description = "Found the trainers name",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Trainer.class))})
    @GetMapping("/trainerCard/findByName/")
    public String findTrainerCardByName(@RequestParam String fullName) {
        return gson.toJson(trainerCardRepository.findByFullName(fullName));
    }
    // получение имен всех тренеров

    @GetMapping("/trainerCard/findAllTrainersName")
    public String findAllTrainersName() {
        val allInfo = trainerCardRepository.findAll()
                .stream()
                .map(Trainer::getFullName)
                .collect(Collectors.toList());
        return gson.toJson(allInfo);

    }

    //создание арены
    @PostMapping("/arena/create/")
    @Transactional
    public void createArena(@RequestBody Arena arena) {
        arenasInfoRepository.save(arena);
    }
    //поиск арены по имени
    @ApiResponse(responseCode = "200", description = "Found the arena",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Arena.class))})
    @GetMapping("/arena/findByName")
    public String findArenaByName(@RequestParam String name) {
        return gson.toJson(arenasInfoRepository.findByName(name));
    }


}
