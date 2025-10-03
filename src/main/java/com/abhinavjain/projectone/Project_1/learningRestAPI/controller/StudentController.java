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

/**
 * Student REST Controller
 * 
 * This controller demonstrates a complete CRUD (Create, Read, Update, Delete) REST API
 * implementation using Spring Boot. It showcases several important concepts:
 * 
 * 1. @RestController: Combination of @Controller + @ResponseBody
 *    - Automatically serializes returned objects to JSON
 *    - Eliminates need for @ResponseBody on each method
 * 
 * 2. @RequestMapping: Base URL mapping for all endpoints in this controller
 *    - All endpoints will be prefixed with "/students"
 * 
 * 3. @RequiredArgsConstructor (Lombok): Generates constructor for final fields
 *    - Enables constructor-based dependency injection
 *    - Cleaner code compared to manual constructor writing
 * 
 * 4. HTTP Methods mapping:
 *    - @GetMapping: Retrieve data (idempotent, safe)
 *    - @PostMapping: Create new resources
 *    - @PutMapping: Full update of existing resources
 *    - @PatchMapping: Partial update of existing resources
 *    - @DeleteMapping: Remove resources
 * 
 * 5. ResponseEntity: Provides fine-grained control over HTTP responses
 *    - Status codes, headers, and body
 *    - Better than returning objects directly
 * 
 * REST API Endpoints:
 * - GET    /students       -> Get all students
 * - GET    /students/{id}  -> Get student by ID
 * - POST   /students       -> Create new student
 * - PUT    /students/{id}  -> Update entire student
 * - PATCH  /students/{id}  -> Partial update student
 * - DELETE /students/{id}  -> Delete student
 * 
 * @author Abhinav Jain
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    /**
     * Service layer dependency injection
     * 
     * Following the Controller -> Service -> Repository pattern:
     * - Controller: Handles HTTP requests/responses
     * - Service: Contains business logic
     * - Repository: Handles data persistence
     */
    private final StudentService studentService;

    /**
     * GET /students
     * 
     * Retrieves all students from the database.
     * 
     * HTTP Method: GET (idempotent and safe)
     * Response: 200 OK with list of students
     * 
     * @return ResponseEntity containing list of all students
     */
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    /**
     * GET /students/{id}
     * 
     * Retrieves a specific student by their ID.
     * 
     * @PathVariable: Extracts the {id} from URL path
     * Response: 200 OK with student data, or 404 if not found
     * 
     * @param id The unique identifier of the student
     * @return ResponseEntity containing the requested student
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    /**
     * POST /students
     * 
     * Creates a new student in the system.
     * 
     * @RequestBody: Deserializes JSON from request body to Java object
     * @Valid: Triggers validation on the DTO object
     * Response: 201 CREATED with the newly created student data
     * 
     * @param addStudentRequestDto DTO containing student creation data
     * @return ResponseEntity with created student information
     */
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createdNewStudent(addStudentRequestDto));
    }

    /**
     * DELETE /students/{id}
     * 
     * Removes a student from the system.
     * 
     * Response: 204 NO CONTENT (successful deletion, no body needed)
     * Alternative: 200 OK with confirmation message
     * 
     * @param id The unique identifier of the student to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * PUT /students/{id}
     * 
     * Completely updates/replaces an existing student.
     * 
     * PUT is idempotent: same request multiple times = same result
     * All fields should be provided (full replacement)
     * 
     * @param id The unique identifier of the student to update
     * @param addStudentRequestDto DTO containing all student data
     * @return ResponseEntity with updated student information
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

    /**
     * PATCH /students/{id}
     * 
     * Partially updates an existing student.
     * 
     * PATCH allows updating only specific fields
     * Uses Map<String, Object> to handle dynamic field updates
     * More flexible than PUT for partial updates
     * 
     * Example request body:
     * {
     *   "name": "Updated Name",
     *   "email": "new.email@example.com"
     * }
     * 
     * @param id The unique identifier of the student to update
     * @param updates Map containing field names and new values
     * @return ResponseEntity with updated student information
     */
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
