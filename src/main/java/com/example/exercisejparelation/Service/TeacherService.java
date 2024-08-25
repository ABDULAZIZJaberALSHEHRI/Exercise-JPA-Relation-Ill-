package com.example.exercisejparelation.Service;

import com.example.exercisejparelation.Api.ApiException;
import com.example.exercisejparelation.Model.Teacher;
import com.example.exercisejparelation.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(int teacher_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public void updateTeacher(int teacher_id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherById(teacher_id);
        if (teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }


    //return All teacher details
    public Teacher getTeacherDetails(int teacher_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }
}
