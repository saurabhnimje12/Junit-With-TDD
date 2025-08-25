package com.example.employeeleavetracker;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int totalLeaves;
    private List<Leave> appliedLeaves = new ArrayList<>();

    public Employee(String name, int totalLeaves) {
        this.name = name;
        this.totalLeaves = totalLeaves;
    }

    public String getName() { return name; }
    public int getTotalLeaves() { return totalLeaves; }
    public List<Leave> getAppliedLeaves() { return appliedLeaves; }

    // Add a leave to the employee's list
    public void applyLeave(Leave leave) {
        appliedLeaves.add(leave);
    }

    // Calculate how many leaves remain
    public int getRemainingLeaves() {
        return totalLeaves - appliedLeaves.size();
    }
}
