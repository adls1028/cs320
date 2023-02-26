/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.adls.appointment.AppointmentService.uuid;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class AppointmentTest {

    public LocalDate date = LocalDate.of(2023,10,31);
    public LocalDate date2 = LocalDate.of(1990,9,12);
    @Test
    public void createNullAppointmentId(){
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment(null, "Halloween", date);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Appointment ID cannot be null", thrown.getMessage());
        System.out.println("Create Null Appointment ID - Passed");
    }

    @Test
    public void createAppointmentIdLargerThanTen(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment("11111111111", "Halloween", date);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Appointment ID cannot be longer than 10 characters", thrown.getMessage());
        System.out.println("Create AppointmentID Longer Than 10 - Passed");
    }

    @Test
    public void createNullDescription(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment(uuid, null,date);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Description cannot be null", thrown.getMessage());
        System.out.println("Create Null Description - Passed");
    }

    @Test
    public void createDescriptionLongerThanFifty(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment(uuid,"Sometimes I like to wear really cool halloween costumes for fun on my birthday",date);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Description cannot be longer than 50 characters", thrown.getMessage());
        System.out.println("Create Description Longer Than Fifty - Passed");

    }

    @Test
    public void createNullDate(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment(uuid, "Halloween", null);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Appointment Date cannot be null", thrown.getMessage());
        System.out.println("Create Null Date - Passed");
    }

    @Test
    public void createDateInPast(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment a1 = new Appointment(uuid,"Halloween", date2);
                    AppointmentService appointmentService = new AppointmentService();
                    System.out.println(AppointmentService.addAppointment(a1));
                });
        Assertions.assertEquals("Appointment Date cannot be in the past", thrown.getMessage());
        System.out.println("Past Date Test - Passed");
    }

}
