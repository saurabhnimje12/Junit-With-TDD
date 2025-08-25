package com.example.employeeleavetracker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 10);
        Employee emp2 = new Employee("Bob", 7);
        LeaveService service = new LeaveService();

        // Define a casual leave policy: leave date must not be in the past
        LeavePolicy casualLeavePolicy = leave -> !leave.getDate().isBefore(LocalDate.now());

        service.applyLeave(emp1, new Leave(LeaveType.CASUAL, LocalDate.now().plusDays(1)), casualLeavePolicy);
        service.applyLeave(emp2, new Leave(LeaveType.SICK, LocalDate.now().plusDays(2)), casualLeavePolicy);

        List<Employee> employees = Arrays.asList(emp1, emp2);
        List<Employee> lowBalance = service.getLowLeaveBalanceEmployees(employees);

        System.out.println("Employees with <5 leaves: ");
        lowBalance.forEach(e -> System.out.println(e.getName() + ": " + e.getRemainingLeaves() + " left"));
    }
}

