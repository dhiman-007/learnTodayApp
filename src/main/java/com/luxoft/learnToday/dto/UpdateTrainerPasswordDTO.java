package com.luxoft.learnToday.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTrainerPasswordDTO {
    private char[] oldPassword;
    private char[] updatedPassword;
}
