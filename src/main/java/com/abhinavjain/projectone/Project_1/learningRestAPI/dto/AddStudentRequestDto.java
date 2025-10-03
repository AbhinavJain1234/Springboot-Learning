package com.abhinavjain.projectone.Project_1.learningRestAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AddStudentRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min=3,max=38,message = "Name length should be between 3 to 38")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
