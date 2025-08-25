package com.example.employeeleavetracker;

@FunctionalInterface
public interface LeavePolicy {
    boolean validate(Leave leave);
}