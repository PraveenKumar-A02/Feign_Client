package com.javatechie.client;

import com.javatechie.dto.Course;
import com.javatechie.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "course-client", url = "${application.services.course.url}")
public interface CourseClient {


    @GetMapping
    List<Course> courses();
    //create a proxy for the CourseClient
    //RestTemplate -> build the request
    // URL , GET , NO , List<COURSE>

    @GetMapping("/{id}")
    Course course(@PathVariable int id);

    @PostMapping("/{id}/ratings")
    String submitRating(@PathVariable int id, @RequestBody Rating rating);

}
