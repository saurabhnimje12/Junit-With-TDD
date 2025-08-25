package com.example.studentgradingsystem;

import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Integer> marks;

    // Constructor to initialize student details
    public Student(String name, String id, List<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            throw new EmptyMarkListException("Mark list cannot be empty.");
        }
        if (marks.stream().anyMatch(m -> m < 0 || m > 100)) {
            throw new InvalidMarkException("Marks must be between 0 and 100.");
        }
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public List<Integer> getMarks() { return marks; }
}
