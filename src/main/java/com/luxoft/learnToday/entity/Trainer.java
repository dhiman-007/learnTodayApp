package com.luxoft.learnToday.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trainerId;

    private String trainerName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private char[] tPassword;

    @ManyToOne
    @JsonIgnore
    private Course course;
}
