package com.example.course_service.serviceimpl;

import com.example.course_service.models.Course;
import com.example.course_service.repositories.CourseRepository;
import com.example.course_service.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedCourse.getName());
                    existing.setDescription(updatedCourse.getDescription());
                    existing.setInstructor(updatedCourse.getInstructor());
                    existing.setRating(updatedCourse.getRating());
                    return courseRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
