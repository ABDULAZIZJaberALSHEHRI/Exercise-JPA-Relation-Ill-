package com.example.exercisejparelation.Controller;

import com.example.exercisejparelation.Model.Course;
import com.example.exercisejparelation.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get-all-courses")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/add-course")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }

    @PutMapping("/update-course/{courseid}")
    public ResponseEntity updateCourse(@PathVariable int courseid, @Valid @RequestBody Course course) {
        courseService.updateCourse(courseid, course);
        return ResponseEntity.status(200).body("Course updated");
    }

    @DeleteMapping("/delete-course/{courseid}")
    public ResponseEntity deleteCourse(@PathVariable int courseid) {
        courseService.deleteCourse(courseid);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @PutMapping("/assign/{cid}/{tid}")
    public ResponseEntity assignCourse(@PathVariable int cid, @PathVariable int tid) {
        courseService.assignCourseToTeacher(cid, tid);
        return ResponseEntity.status(200).body("Course assigned");
    }

    //take course id and return the teacher name for that class
    @GetMapping("/get-teacher-name-by-course-id/{courseid}")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable int courseid) {
        return ResponseEntity.status(200).body(courseService.teacherNameByCourseID(courseid));
    }

    // takes course id and return the student list
    @GetMapping("/get-students-by-course/{courseid}")
    public ResponseEntity getStudentsByCourseId(@PathVariable int courseid) {
        return ResponseEntity.status(200).body(courseService.getStudentsByCourseID(courseid));
    }
}

