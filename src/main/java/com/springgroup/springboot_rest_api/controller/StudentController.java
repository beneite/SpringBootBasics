package com.springgroup.springboot_rest_api.controller;

import com.springgroup.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    // url: http://localhost:8080/getStudentDetails
    @GetMapping("/getStudentDetails")
    public Student returnStudentDetails(){
        Student student = new Student(1, "Ashish", "Mishra");
        return student;
    }

    // url: http://localhost:8080/getAllStudentDetails
    @GetMapping("/getAllStudentDetails")
    public List<Student> returnAllStudentDetails(){
        ArrayList<Student> allStudentList = new ArrayList<>();
        allStudentList.add(new Student(1, "Ashish", "Mishra"));
        allStudentList.add(new Student(2, "Virat", "Ghanguly"));
        allStudentList.add(new Student(3, "Jadega", "Kohli"));
        allStudentList.add(new Student(4, "Ravindra", "Pawar"));
        allStudentList.add(new Student(5, "Mukesh", "Jha"));

        return allStudentList;
    }
}
