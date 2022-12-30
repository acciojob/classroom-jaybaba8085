package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@RestController
public class StudentRepository {

    HashMap<String, Student> studentMap = new HashMap<>();
    HashMap<String, Teacher> teacherMap = new HashMap<>();

    HashMap<String, List<String>>pair=new HashMap<>();

//1
    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }
//2
    public  void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }
//3
    public  void addStudentTeacherPair(String studentName, String teacherName) {
        if (studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)) {
            if (pair.containsKey(teacherName)) {
                List<String> l=pair.get(teacherName);
                l.add(studentName);
                pair.put(teacherName,l);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(studentName);
                pair.put(teacherName, ls);
            }
        }
    }

//4
    public Student getStudentByName(String name) {
        return studentMap.get(name);
    }

//5
    public Teacher getTeacherByName(String name) {
        return teacherMap.get(name);
    }

//6
    public List<String> getStudentByTeacherName(String teacher) {
        return  pair.get(teacher);
    }

//7
    public List<String> getAllStudent() {
        List<String>ls= new ArrayList<>();
        for(String name:studentMap.keySet())
        {
            ls.add(name);
        }
        return new ArrayList<>(ls);
    }

//8
    public void deleteTecherByName(String teacher) {
        if(teacherMap.containsKey(teacher)){
            if(pair.containsKey(teacher)){
                List<String>Sts=pair.get(teacher);
                for(String s:Sts)
                {
                    if(studentMap.containsKey(s))
                    {
                       studentMap.remove(s);
                    }
                }
                teacherMap.remove(teacher);
                pair.remove(teacher);
            }
        }
    }

//9
    public void deleteAllTeachers() {
        for(String teacher:teacherMap.keySet()){
            if(pair.containsKey(teacher))
            {
                List<String> StudentList=pair.get(teacher);
                for(String s:StudentList)
                {
                    if(studentMap.containsKey(s))
                    {
                        studentMap.remove(s);
                    }
                }
            }
            pair.clear();
            teacherMap.clear();;
        }
        pair.clear();
        teacherMap.clear();
    }
}
