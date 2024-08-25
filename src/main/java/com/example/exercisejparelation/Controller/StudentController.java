package com.example.exercisejparelation.Controller;

import com.example.exercisejparelation.Model.Student;
import com.example.exercisejparelation.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get-all-students")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add-student")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added successfully");
    }

    @PutMapping("/update-student/{studentid}")
    public ResponseEntity updateStudent(@PathVariable int studentid ,@Valid @RequestBody Student student) {
        studentService.updateStudent(studentid, student);
        return ResponseEntity.status(200).body("Student updated successfully");
    }

    @DeleteMapping("/delete-student/{studentid}")
    public ResponseEntity deleteStudent(@PathVariable int studentid) {
        studentService.deleteStudent(studentid);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }

    //assign student to course
    @PutMapping("/assign/{studentid}/{courseid}")
    public ResponseEntity assignStudentToCourse(@PathVariable int studentid, @PathVariable int courseid) {
        studentService.assignStudentToCourse(studentid, courseid);
        return ResponseEntity.status(200).body("Student assigned to course successfully");
    }

    //takes student id and major and change the student major
    @PutMapping("/change-major/{studentid}/{newmajor}")
    public ResponseEntity changeMajor(@PathVariable int studentid, @PathVariable String newmajor) {
        studentService.changeMajor(studentid, newmajor);
        return ResponseEntity.status(200).body("Student major changed successfully");
    }
}
