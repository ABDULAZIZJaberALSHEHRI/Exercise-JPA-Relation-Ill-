package com.example.exercisejparelation.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {


    @NotNull(message = "TeacherService id should not be empty!")
    @Positive(message = "TeacherService id should be positive number!")
    private Integer teacher_id;

    @NotEmpty(message = "Area should not be empty!")
    @Size(max = 25,message = "area length should be less than 25 chars!")
    private String area;

    @NotEmpty(message = "Street should not be empty!")
    @Size(max = 20,message = "Street length should be less than 20 chars!")
    private String street;

    @NotNull(message = "building number should not be empty!")
    @Positive(message = "Building number should be positive number!")
    private int buildingNumber;
}
