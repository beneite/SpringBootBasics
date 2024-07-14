package com.springgroup.springboot_rest_api.controller;

import com.springgroup.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
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

    // url: http://localhost:8080/getStudentData/2/Ashish/Mishra
    // REST Api using path variable
    @GetMapping("/getStudentData/{id}/{first-name}/{last-name}")
    public Student returnStudentData(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // url: http://localhost:8080/student/query?id=1&firstName=Ashish&lastName=Mishra
    // REST Api using request params/ query param
    @GetMapping("/student/query")
    public Student getStudentWithQueryParams(@RequestParam("id") int studentId, @RequestParam("firstName") String studentFirstName, @RequestParam("lastName") String studentLastName){
        return new Student(studentId, studentFirstName, studentLastName);
    }

    // url: http://localhost:8080/student/create
    // REST Api [POST] to add student record
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudentRecord(@RequestBody Student student){
        System.out.println("Record created");
        System.out.println(student.getStudentId());
        System.out.println(student.getStudentFirstName());
        System.out.println(student.getStudentLastName());
        return student;
    }

}
