package com.cazacubrindusa.demo.model;

public class Thesis {
    private Long id;
    private String title;
    private String description;
    private String studentName;
    private String advisorName;

    public Thesis() {}

    public Thesis(Long id, String title, String description, String studentName, String advisorName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.studentName = studentName;
        this.advisorName = advisorName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getAdvisorName() { return advisorName; }
    public void setAdvisorName(String advisorName) { this.advisorName = advisorName; }
}
