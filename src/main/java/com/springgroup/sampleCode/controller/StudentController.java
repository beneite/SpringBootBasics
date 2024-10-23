package com.springgroup.sampleCode.controller;

import com.springgroup.sampleCode.bean.Student;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("MyCustomApi")
public class StudentController {

    // url: http://localhost:8080/MyCustomApi/MyCustomApi/getStudentDetails
    @GetMapping("/getStudentDetails")
    public Student returnStudentDetails(){
        Student student = new Student(1, "Ashish", "Mishra");
        return student;
    }

    // url: http://localhost:8080/MyCustomApi/getAllStudentDetails
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

    // url: http://localhost:8080/MyCustomApi/getStudentData/2/Ashish/Mishra
    // REST Api using path variable
    @GetMapping("/getStudentData/{id}/{first-name}/{last-name}")
    public Student returnStudentData(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // url: http://localhost:8080/MyCustomApi/student/query?id=1&firstName=Ashish&lastName=Mishra
    // REST Api using request params/ query param
    @GetMapping("/student/query")
    public Student getStudentWithQueryParams(@RequestParam("id") int studentId, @RequestParam("firstName") String studentFirstName, @RequestParam("lastName") String studentLastName){
        return new Student(studentId, studentFirstName, studentLastName);
    }

    // url: http://localhost:8080/MyCustomApi/student/create
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

    // url: http://localhost:8080/MyCustomApi/student/3/update
    // REST Api [PUT] to update student record
    @PutMapping("/student/{id}/update")
    public Student updateStudentRecord(@RequestBody Student student, @PathParam("id") Integer studentId){
        System.out.println(student.getStudentFirstName());
        System.out.println(student.getStudentLastName());
        return student;
    }

    // url: http://localhost:8080/MyCustomApi/student/3/delete
    // REST Api [DELETE] to delete student record
    @DeleteMapping("/student/{id}/delete")
    public String deleteStudentRecord(@PathParam("id") Integer studentId){
        return "Record deleted";
    }

    // url: http://localhost:8080/MyCustomApi/getStudentDetailsUsingResponseEntity
    // ResponseEntity example
    @GetMapping("/getStudentDetailsUsingResponseEntity")
    public ResponseEntity<Student> returnStudentDetailsWithResponseEntity(){
        Student student = new Student(1, "Ashish", "Mishra");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // url: http://localhost:8080/MyCustomApi/getStudentDetailsUsingResponseEntityWithHeaders
    // ResponseEntity example with headers
    @GetMapping("/getStudentDetailsUsingResponseEntityWithHeaders")
    public ResponseEntity<Student> returnStudentDetailsWithResponseEntityWithHeaders(){
        Student student = new Student(1, "Ashish", "Mishra");
        return ResponseEntity.ok().
                header("my-header","Ashish-header")
                .body(student);
    }

    // url: http://localhost:8080/MyCustomApi/getAllStudentDetailsUsingResponseEntity
    // ResponseEntity example with Ok static method
    @GetMapping("/getAllStudentDetailsUsingResponseEntity")
    public ResponseEntity<List<Student>> returnAllStudentDetailsUsingResponseEntity(){
        ArrayList<Student> allStudentList = new ArrayList<>();
        allStudentList.add(new Student(1, "Aman", "Mishra"));
        allStudentList.add(new Student(2, "Virat", "Ghanguly"));
        allStudentList.add(new Student(3, "Jadega", "Kohli"));
        allStudentList.add(new Student(4, "Ravindra", "Pawar"));
        allStudentList.add(new Student(5, "Mukesh", "Jha"));

        return ResponseEntity.ok(allStudentList);
    }

    // url: http://localhost:8080/MyCustomApi/student/createUsingResponseEntity
    // REST Api [POST] to add student record using response entity
    @PostMapping("/student/createUsingResponseEntity")
    public ResponseEntity<Student> createStudentRecordUsingResponseEntity(@RequestBody Student student){
        System.out.println("Record created");
        System.out.println(student.getStudentId());
        System.out.println(student.getStudentFirstName());
        System.out.println(student.getStudentLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
