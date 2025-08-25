package com.example.employeeleavetracker;

import java.util.List;
import java.util.stream.Collectors;

public class LeaveService {

    // Apply a leave based on policy
    public void applyLeave(Employee emp, Leave leave, LeavePolicy policy) {
        if (!policy.validate(leave)) {
            throw new InvalidLeaveDateException("Leave date is invalid.");
        }

        if (emp.getRemainingLeaves() <= 0) {
            throw new LeaveLimitExceededException("No leaves remaining.");
        }

        emp.applyLeave(leave);
    }

    // Get employees with fewer than 5 leaves remaining
    public List<Employee> getLowLeaveBalanceEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(emp -> emp.getRemainingLeaves() < 5)
                .collect(Collectors.toList());
    }
}
