package com.example.student_service.models;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private String name;
    private String description;
    private String instructor;
    private Double rating;
}
