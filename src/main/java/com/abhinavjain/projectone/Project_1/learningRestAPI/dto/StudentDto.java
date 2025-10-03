package com.abhinavjain.projectone.Project_1.learningRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
}

//    Either use this whole or use @Data annotation but not for constructor
//
//public StudentDto(Long id, String name, String email) {
//    this.id = id;
//    this.name = name;
//    this.email = email;
//}
//
//    public StudentDto() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }