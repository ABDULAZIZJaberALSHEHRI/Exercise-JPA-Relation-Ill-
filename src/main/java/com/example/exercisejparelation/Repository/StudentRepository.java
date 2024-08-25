package com.example.exercisejparelation.Repository;

import com.example.exercisejparelation.Model.Course;
import com.example.exercisejparelation.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(int id);

    Student findStudentByCourses(Set<Course> courses);
}
