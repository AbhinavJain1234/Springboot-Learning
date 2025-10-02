package com.abhinavjain.projectone.Project_1.learningRestAPI.controller;

import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.AddStudentRequestDto;
import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.StudentDto;
import com.abhinavjain.projectone.Project_1.learningRestAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createdNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
