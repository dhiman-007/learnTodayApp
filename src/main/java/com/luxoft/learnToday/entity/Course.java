package com.luxoft.learnToday.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;

    private String courseTitle;
    private Double courseFees;
    private String courseDescription;
    private String courseStartDate;

    @OneToMany(mappedBy = "course")
    private List<Trainer> trainers;

    @OneToMany(mappedBy = "course")
    private List<Student> students;

}
