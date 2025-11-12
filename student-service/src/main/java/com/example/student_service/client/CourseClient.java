package com.example.student_service.client;

import com.example.student_service.models.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@FeignClient(name="course-service",url="http://localhost:8081")
public interface CourseClient {
    @GetMapping("/api/courses")
    List<Course> getAllCourses();

    @GetMapping("/api/courses/{id}")
    Course getCourseById(@PathVariable("id") Long id);
}
