package com.example.exercisejparelation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    private String area;

    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @Column(columnDefinition = "int not null")
    private int buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
