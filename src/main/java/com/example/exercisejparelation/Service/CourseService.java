package com.example.exercisejparelation.Service;

import com.example.exercisejparelation.Api.ApiException;
import com.example.exercisejparelation.Model.Course;
import com.example.exercisejparelation.Model.Student;
import com.example.exercisejparelation.Model.Teacher;
import com.example.exercisejparelation.Repository.CourseRepository;
import com.example.exercisejparelation.Repository.StudentRepository;
import com.example.exercisejparelation.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(int course_ID,Course course) {
        Course c = courseRepository.findCourseById(course_ID);

        if(c == null) {
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(int course_ID) {
        Course c = courseRepository.findCourseById(course_ID);
        if(c == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(c);
    }

    public void assignCourseToTeacher(int course_ID,int teacher_id) {
        Course c = courseRepository.findCourseById(course_ID);
        Teacher t = teacherRepository.findTeacherById(teacher_id);
        if(c == null || t == null) {
            throw new ApiException("Course or Teacher not found");
        }

        c.setTeacher(t);
        courseRepository.save(c);
    }

    // take course id and return the teacher name for that class
    public String teacherNameByCourseID(int course_ID) {
        Course c = courseRepository.findCourseById(course_ID);
        if(c == null) {
            throw new ApiException("Course not found");
        }
        if (c.getTeacher().getName()==null){
            throw new ApiException("Teacher doesn't have course");
        }
        return c.getTeacher().getName();

    }

    // takes course id and return the student list
    public Set<Student> getStudentsByCourseID(int course_ID) {

          Course c = courseRepository.findCourseById(course_ID);
          if(c == null) {
              throw new ApiException("Course not found");
          }

        return c.getStudents();
    }
}
