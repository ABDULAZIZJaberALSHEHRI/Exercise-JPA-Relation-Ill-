package com.example.exercisejparelation.Controller;

import com.example.exercisejparelation.Model.Teacher;
import com.example.exercisejparelation.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {
    private final TeacherService teacherService;


    @GetMapping("/get-all-teachers")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add-teacher")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added successfully");
    }

    @PutMapping("/update-teacher/{teacherid}")
    public ResponseEntity updateTeacher(@PathVariable int teacherid,@Valid @RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacherid,teacher);
        return ResponseEntity.status(200).body("teacher updated successfully");
    }

    @DeleteMapping("/delete-teacher/{teacherid}")
    public ResponseEntity deleteTeacher(@PathVariable int teacherid) {
        teacherService.deleteTeacher(teacherid);
        return ResponseEntity.status(200).body("teacher deleted successfully");
    }

    //return All teacher details
    @GetMapping("/get-teacher-details/{teacherid}")
    public ResponseEntity getTeacherDetails(@PathVariable int teacherid) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(teacherid));
    }
}
