package com.luxoft.learnToday.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainerDto {

    private Integer trainerId;
    private Integer courseId;

}
