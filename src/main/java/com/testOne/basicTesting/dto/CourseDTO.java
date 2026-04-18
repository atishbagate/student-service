package com.testOne.basicTesting.dto;

public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private String instructor;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, String description, String instructor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
