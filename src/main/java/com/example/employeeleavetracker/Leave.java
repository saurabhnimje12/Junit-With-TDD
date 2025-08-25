package com.example.employeeleavetracker;

import java.time.LocalDate;

public class Leave {
    private LeaveType type;
    private LocalDate date;

    public Leave(LeaveType type, LocalDate date) {
        this.type = type;
        this.date = date;
    }

    public LeaveType getType() { return type; }
    public LocalDate getDate() { return date; }
}
