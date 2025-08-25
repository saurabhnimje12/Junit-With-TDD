package com.example.studentgradingsystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", "S101", Arrays.asList(85, 90, 88, 70));

        GradingService service = new GradingService();

        // Lambda-based grading strategy
        GradingStrategy simpleGrading = avg -> {
            if (avg >= 85) return "A";
            else if (avg >= 70) return "B";
            else if (avg >= 50) return "C";
            else return "Fail";
        };

        String grade = service.gradeStudent(s, simpleGrading);
        System.out.println(s.getName() + " scored an average of " +
                service.calculateAverage(s.getMarks()) + " and got grade: " + grade);
    }
}