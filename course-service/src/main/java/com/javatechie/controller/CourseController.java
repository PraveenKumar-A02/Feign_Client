package com.javatechie.controller;

import com.javatechie.dto.Course;
import com.javatechie.dto.Rating;
import com.javatechie.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {

        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/ratings")
    public ResponseEntity<String> addRating(@PathVariable int id, @RequestBody Rating rating) {
        boolean added = courseService.addRating(id, rating);
        if (added) {
            return ResponseEntity.ok("Rating submitted successfully!");
        } else {
            return ResponseEntity.badRequest().body("Course not found.");
        }
    }

}
