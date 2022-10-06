package com.luxoft.learnToday.controller;

import com.luxoft.learnToday.dto.TrainerDto;
import com.luxoft.learnToday.dto.UpdateTrainerPasswordDTO;
import com.luxoft.learnToday.entity.Trainer;
import com.luxoft.learnToday.service.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Trainer")
public class TrainerController {

    @Autowired
    private TrainerServiceImpl trainerService;

    @PostMapping
    public ResponseEntity<Trainer> trainerSignUp(@RequestBody Trainer trainer) {
        Trainer signedUpTrainer  = trainerService.trainerSignUp(trainer);
        return new ResponseEntity<Trainer>(signedUpTrainer, HttpStatus.CREATED);
    }

    @PutMapping("/{trainerId}")
    public ResponseEntity<String> updateTrainerPassword(@PathVariable Integer trainerId, @RequestBody UpdateTrainerPasswordDTO trainer) {
        final String updateRes = trainerService.updateTrainerPassword(trainerId, trainer);
        return new ResponseEntity<String>(updateRes, HttpStatus.OK);
    }

    @PostMapping("/assignCourse")
    public ResponseEntity<Trainer> assignCourseToTrainer(@RequestBody TrainerDto trainerDto){
        Trainer updatedTrainer  = trainerService.assignCourseToTrainer(trainerDto);
        return new ResponseEntity<Trainer>(updatedTrainer, HttpStatus.CREATED);
    }

}
