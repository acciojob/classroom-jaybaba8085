package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

//1
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
//2
    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }
//3
    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }
//4
    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }
//5
    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);
    }
//6
    public List<String> getStudentsByTeacherName(String teacher) {
        return (List<String>) studentRepository.getStudentByTeacherName(teacher);
    }
//7
    public List<String> getAllStudents() {
        return (List<String>) studentRepository.getAllStudent();
    }
//8
    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTecherByName(teacher);
    }
//9
    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
