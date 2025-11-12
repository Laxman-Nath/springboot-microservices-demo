package com.example.course_service.services;

import com.example.course_service.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {


     List<Course> getAllCourses();

     Optional<Course> getCourseById(Long id);

     Course createCourse(Course course) ;

     Course updateCourse(Long id, Course updatedCourse) ;
     void deleteCourse(Long id);
}
