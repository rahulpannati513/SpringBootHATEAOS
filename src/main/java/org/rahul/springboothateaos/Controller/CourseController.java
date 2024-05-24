package org.rahul.springboothateaos.Controller;

import org.rahul.springboothateaos.POJO.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {


    @GetMapping("getCourses/{cid}")
    public ResponseEntity<Course> getCourseInfo(@PathVariable("cid") String cid){

        Course course = new Course(1, "Spring Boot", 900.0, "Hyder Abbas");

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getAllCourses()).withRel("suggested-coureses");

        course.add(link);
        //        WebMvcLinkBuilder web = WebMvcLinkBuilder.linkTo(getAllCourses());
//        course.add(web.withRel("All-Courses"));
        return new  ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses(){

        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Spring Boot", 900.0, "Hyder Abbas"));
        courses.add(new Course(2, "Spring MVC", 800.0, "Rahul Pannati"));
        courses.add(new Course(3, "Spring Data JPA", 1000.0, "Virat Kholi"));


            return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
