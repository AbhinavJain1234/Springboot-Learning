package com.abhinavjain.projectone.Project_1.learningRestAPI.service;

import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.AddStudentRequestDto;
import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentByID(Long id);

    StudentDto createdNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
