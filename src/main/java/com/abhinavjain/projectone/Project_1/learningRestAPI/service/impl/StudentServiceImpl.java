package com.abhinavjain.projectone.Project_1.learningRestAPI.service.impl;

import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.AddStudentRequestDto;
import com.abhinavjain.projectone.Project_1.learningRestAPI.dto.StudentDto;
import com.abhinavjain.projectone.Project_1.learningRestAPI.entity.Student;
import com.abhinavjain.projectone.Project_1.learningRestAPI.repository.StudentRepository;
import com.abhinavjain.projectone.Project_1.learningRestAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students=studentRepository.findAll();
//        return students
//                .stream().
//                map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
//                .toList();
        return students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentByID(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found by Id"));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createdNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent=modelMapper.map(addStudentRequestDto,Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if(studentRepository.existsById(id))studentRepository.deleteById(id);
        else throw new IllegalArgumentException("Student does not exist by id"+id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student=studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No Student found with id "+id));
        modelMapper.map(addStudentRequestDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No Student found with id "+id));
        updates.forEach((feild,value)->{
            switch (feild){
                case "name":student.setName(value.toString());break;
                case "email":student.setEmail(value.toString());break;
                default:
                    throw new IllegalArgumentException("Field: "+feild+" is not a valid field");
            }
        });
        Student savedstudent=studentRepository.save(student);
        return modelMapper.map(savedstudent,StudentDto.class);
    }

}
