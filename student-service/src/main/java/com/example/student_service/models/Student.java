package com.example.student_service.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Student name is required")
        private String name;

        @Email(message = "Email should be valid")
        @Column(unique = true)
        private String email;

        private Long enrolledCourseId; // will store Course ID from Course Service
    @Column(nullable = true)
        private String enrolledCourseName;

        private Double progress = 0.0;
}
