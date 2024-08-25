package com.example.exercisejparelation.Repository;

import com.example.exercisejparelation.Model.Course;
import com.example.exercisejparelation.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

    Course findCoursesByStudents(Set<Student> students);
}
