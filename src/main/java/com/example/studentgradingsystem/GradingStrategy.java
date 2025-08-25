package com.example.studentgradingsystem;

// Functional interface for applying grading strategies
@FunctionalInterface
public interface GradingStrategy {
    String assignGrade(double average);
}