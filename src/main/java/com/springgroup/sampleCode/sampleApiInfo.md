## Below are the APIs

> [!WARNING]
> the below request are just sample/skeleton request not the actual request and are present in this [controller](controller/StudentController.java) file.

## [GET] Simple get request:

```java
// url: http://localhost:8080/getStudentDetails
@GetMapping("/getStudentDetails")
public Student returnStudentDetails(){
        Student student=new Student(1,"Ashish","Mishra");
        return student;
        }
```

<hr style="border:2px solid cyan">

## [GET] Creating get request with path variable: (sample)

```java
// url: http://localhost:8080/getStudentData/2/Ashish/Mishra
// REST Api using path variable
@GetMapping("/getStudentData/{id}/{first-name}/{last-name}")
public Student returnStudentData(@PathVariable("id") int studentId,@PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
        }
```

<hr style="border:2px solid cyan">

## [GET] Creating get Api using request params/ query param:  (sample)

```java
// url: http://localhost:8080/student/query?id=1&firstName=Ashish&lastName=Mishra
// REST Api using request params/ query param
@GetMapping("/student/query")
public Student getStudentWithQueryParams(@RequestParam("id") int studentId,@RequestParam("firstName") String studentFirstName,@RequestParam("lastName") String studentLastName){
        return new Student(studentId,studentFirstName,studentLastName);
        }
```

<hr style="border:2px solid cyan">

## [POST] to create a student record

```java
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
```

<hr style="border:2px solid cyan">

## [PUT] to update student record

```java
// url: http://localhost:8080/student/3/update
// REST Api [PUT] to update student record
@PutMapping("/student/{id}/update")
public Student updateStudentRecord(@RequestBody Student student,@PathParam("id") Integer studentId){
        System.out.println(student.getStudentFirstName());
        System.out.println(student.getStudentLastName());
        return student;
        }
```

<hr style="border:2px solid cyan">

## [DELETE] to delete student record

```java
// url: http://localhost:8080/student/3/delete
// REST Api [DELETE] to delete student record
@DeleteMapping("/student/{id}/delete")
public String deleteStudentRecord(@PathParam("id") Integer studentId){
        return"Record deleted";
        }
```

<hr style="border:2px solid cyan">