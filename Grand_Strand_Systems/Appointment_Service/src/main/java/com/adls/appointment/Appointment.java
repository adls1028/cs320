/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.appointment;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {

    private final String appointmentId;
    private String description;

    private final LocalDate appointmentDate;

    static boolean numbers = true;
    static boolean letters = true;
    public static int uuidLength = 10;
    private final int descriptionLength = 50;

    public Appointment(String appointmentId, String description, LocalDate date) {
        LocalDate today = LocalDate.now();
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        else if (appointmentId.length() > uuidLength) {
            throw new IllegalArgumentException("Appointment ID cannot be longer than " + uuidLength + " characters");
        }
        else {
            this.appointmentId = appointmentId;
        }
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        else if (description.length() > descriptionLength) {
            throw new IllegalArgumentException("Description cannot be longer than " + descriptionLength + " characters");
        }
        else {
            this.description = description;
        }
        if (date == null) {
            throw new IllegalArgumentException("Appointment Date cannot be null");
        }
        else if (date.isBefore(today)) {
            throw new IllegalArgumentException("Appointment Date cannot be in the past");
        }
        else {
            this.appointmentDate = date;
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppointmentDate(LocalDate date) {
        LocalDate today = LocalDate.now();
    }

    @Override
    public String toString() {
        return "["+appointmentId+","+description+","+appointmentDate+"]";
    }
}