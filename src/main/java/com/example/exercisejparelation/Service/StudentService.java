package com.example.exercisejparelation.Service;

import com.example.exercisejparelation.Api.ApiException;
import com.example.exercisejparelation.Model.Course;
import com.example.exercisejparelation.Model.Student;
import com.example.exercisejparelation.Repository.CourseRepository;
import com.example.exercisejparelation.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int student_id) {
        Student student = studentRepository.findStudentById(student_id);

        if (student == null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    public void updateStudent(int student_id, Student student) {
        Student student1 = studentRepository.findStudentById(student_id);
        if (student1 == null){
            throw new ApiException("Student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }

    //assign student to course
    public void assignStudentToCourse(int student_id, int course_id) {
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if (student == null || course == null){
            throw new ApiException("Student OR course not found");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    //takes student id and major and change the student major
    public void changeMajor(int student_id, String major) {
        Student student = studentRepository.findStudentById(student_id);
        if (student == null){
            throw new ApiException("Student not found");
        }


        student.setMajor(major);

        // drop all the coursers that the student attended to
        for (Course course : student.getCourses()){
            course.getStudents().remove(student);
        }

        studentRepository.save(student);

    }


}
