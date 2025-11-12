package com.example.student_service.serviceimpls;

import com.example.student_service.client.CourseClient;
import com.example.student_service.models.Course;
import com.example.student_service.models.Student;
import com.example.student_service.repositories.StudentRepository;
import com.example.student_service.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final CourseClient courseClient;

    public StudentServiceImpl(StudentRepository repository,CourseClient courseClient) {
        this.repository = repository;
        this.courseClient=courseClient;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        Course course=courseClient.getCourseById(student.getEnrolledCourseId());

        if(course==null){
           throw new RuntimeException("Invalid id of course............");
        }
        student.setEnrolledCourseName(course.getName());
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        if(courseClient.getCourseById(updatedStudent.getEnrolledCourseId())==null){
            throw new RuntimeException("Invalid id of course............");
        }

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setEnrolledCourseId(updatedStudent.getEnrolledCourseId());
        existing.setEnrolledCourseName(updatedStudent.getEnrolledCourseName());
        existing.setProgress(updatedStudent.getProgress());

        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Student not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
