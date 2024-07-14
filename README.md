# This repo contains the basics of Sprint boot.

> [!WARNING] 
> the below request are just sample/skeleton request not the actual request.

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



# Read Me First

The following was discovered as part of building this project:

* The original package name 'com.springgroup.springboot-rest-api' is invalid and this project uses '
  com.springgroup.springboot_rest_api' instead.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

