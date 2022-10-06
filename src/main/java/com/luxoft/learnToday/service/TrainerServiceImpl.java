package com.luxoft.learnToday.service;

import com.luxoft.learnToday.dto.TrainerDto;
import com.luxoft.learnToday.dto.UpdateTrainerPasswordDTO;
import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.entity.Trainer;
import com.luxoft.learnToday.exception.DataNotFoundException;
import com.luxoft.learnToday.repository.CourseRepository;
import com.luxoft.learnToday.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Trainer trainerSignUp(Trainer trainer) {
        Trainer signedUpTrainer = null;
        try {
            char[] hashedPassword = getHashedPassword(trainer.getTPassword());
            trainer.setTPassword(hashedPassword);
            signedUpTrainer = trainerRepository.save(trainer);
        }
        catch (DataNotFoundException e){
            e.setErrorMessage("Unable to signUp trainer.");
        }
        return signedUpTrainer;
    }

    private char[] getHashedPassword(char[] trainerPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String tPassword = passwordEncoder.encode(String.valueOf(trainerPassword));
        return tPassword.toCharArray();
    }

    @Override
    public String updateTrainerPassword(Integer trainerId, UpdateTrainerPasswordDTO trainer) {
        String updateRes = null;
        try{
           if(trainerRepository.existsById(trainerId)){
               Trainer existingTrainer = trainerRepository.findById(trainerId).get();
               char[] existingTrainerPassword = existingTrainer.getTPassword();
               char[] trainerOldPassword = trainer.getOldPassword();
               BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
               if(passwordEncoder.matches(String.valueOf(trainerOldPassword), String.valueOf(existingTrainerPassword))){
                   existingTrainer.setTPassword(getHashedPassword(trainer.getUpdatedPassword()));
                   trainerRepository.save(existingTrainer);
                   updateRes = "trainer Password Updated Successfully for trainer with Id : " + trainerId;
               }
               else{
                   updateRes = "Please provide correct current Password.";
               }
           }
        }
        catch (DataNotFoundException e){
            e.setErrorMessage("Something went wrong!");
        }
        return updateRes;
    }

    @Override
    public Trainer assignCourseToTrainer(TrainerDto trainerDto) {
        Trainer trainer = trainerRepository.findById(trainerDto.getTrainerId())
                .orElseThrow(() ->
                        new DataNotFoundException("Trainer not found with trainerId : " + trainerDto.getTrainerId()));
        Course course = courseRepository.findById(trainerDto.getCourseId())
                .orElseThrow(() ->
                        new DataNotFoundException("Course Not found with courseId : " + trainerDto.getCourseId()));

        trainer.setCourse(course);

        trainerRepository.save(trainer);
        return trainer;
    }


}
