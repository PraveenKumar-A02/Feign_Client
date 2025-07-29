package com.javatechie.controller;

import com.javatechie.dto.Course;
import com.javatechie.dto.Rating;
import com.javatechie.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search/{courseId}")
    public Course search(@PathVariable int courseId) {
        return studentService.searchCourse(courseId);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return studentService.getAllCourses();
    }
    @PostMapping("/courses/{courseId}/ratings")
    public String submitRating(@PathVariable int courseId, Rating rating) {
        return studentService.submitRating(courseId, rating);
    }
}
