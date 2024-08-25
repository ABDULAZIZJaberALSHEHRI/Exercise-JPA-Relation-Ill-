package com.example.exercisejparelation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Student name should not be empty!")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotNull(message = "Student age should not be empty!")
    @Positive(message = "Student age should be positive number!")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Student major should not be empty!")
    @Column(columnDefinition = "varchar(25) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
