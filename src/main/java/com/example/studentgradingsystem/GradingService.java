package com.example.studentgradingsystem;

import java.util.List;

public class GradingService {

    // Calculates average marks using Stream API
    public double calculateAverage(List<Integer> marks) {
        return marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    // Applies grading strategy to determine grade
    public String gradeStudent(Student student, GradingStrategy strategy) {
        double avg = calculateAverage(student.getMarks());
        return strategy.assignGrade(avg);
    }
}