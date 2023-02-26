/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.appointment;

import org.junit.jupiter.api.Test;

import com.adls.appointment.Appointment;
import com.adls.appointment.AppointmentService;

import java.time.LocalDate;

import static com.adls.appointment.AppointmentService.uuid;

public class AppointmentServiceTest {

    public LocalDate date = LocalDate.of(2023,10,31);
    public LocalDate date2 = LocalDate.of(2023,10,30);
    @Test
    public void createModifyandDeleteAppointment(){
        System.out.println(date);
        System.out.println(uuid);
        Appointment a1 = new Appointment(uuid,"Christmas!",date);
        AppointmentService appointmentService = new AppointmentService();
        System.out.println(appointmentService.addAppointment(a1));
        System.out.println(appointmentService.updateAppointment(uuid,"Christmas Eve",date2));
        System.out.println(appointmentService.deleteAppointment(uuid));

    }
}
