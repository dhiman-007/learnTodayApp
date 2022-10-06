package com.luxoft.learnToday.service;

import com.luxoft.learnToday.dto.TrainerDto;
import com.luxoft.learnToday.dto.UpdateTrainerPasswordDTO;
import com.luxoft.learnToday.entity.Trainer;

public interface TrainerService {

    Trainer trainerSignUp(Trainer trainer);

    String updateTrainerPassword(Integer trainerId, UpdateTrainerPasswordDTO trainer);

    Trainer assignCourseToTrainer(TrainerDto trainerDto);


}
