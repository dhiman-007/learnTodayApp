package com.luxoft.learnToday.repository;

import com.luxoft.learnToday.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
