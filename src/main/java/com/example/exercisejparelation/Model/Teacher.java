package com.example.exercisejparelation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;

    @NotEmpty(message = "TeacherService name should not be empty!")
    @Size(min = 2,max = 25,message = "TeacherService name should be more the 2 and less than 25 char!")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "TeacherService name must contain only characters")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotNull(message = "TeacherService age should not be empty!")
    @Positive(message = "TeacherService age should be positive number!")
    @Min(value = 24,message = "TeacherService age should be more than 24")
    @Column(columnDefinition = "int not null")
    private int age;

    @Email(message = "not valid email")
    @NotEmpty(message = "Email should not be empty!")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String email;

    @NotNull(message = "Salary should not be empty!")
    @Positive(message = "Salary should be positive number!")
    @Column(columnDefinition = "int not null")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
