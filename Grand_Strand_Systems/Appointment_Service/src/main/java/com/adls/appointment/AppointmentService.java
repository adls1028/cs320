/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.appointment;

import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.adls.appointment.Appointment.*;

public class AppointmentService {

    public static final String uuid = RandomStringUtils.random(uuidLength, letters, numbers);

    private static final Map<String, Appointment> appointments = new HashMap<>();


    public static Map<String, Appointment> addAppointment(Appointment appointment) {
        String uuid = AppointmentService.uuid;
        appointments.put(uuid, appointment);
        return appointments;
    }

    public static Map<String, Appointment> deleteAppointment(String appointmentId) {
        Iterator itr = appointments.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Integer, Appointment> entry = (Map.Entry<Integer, Appointment>) itr.next();
            if (entry.getValue().getAppointmentId() == appointmentId) {
                itr.remove();
            }
        }
        return appointments;
    }

    public static Map<String, Appointment> updateAppointment(String appointmentId, String description, LocalDate date) {
        Iterator itr = appointments.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Integer, Appointment> entry = (Map.Entry<Integer, Appointment>) itr.next();
            if (entry.getValue().getAppointmentId() == appointmentId) {
                entry.getValue().setDescription(description);
                entry.getValue().setAppointmentDate(date);
            }
        }
        return appointments;
    }
}