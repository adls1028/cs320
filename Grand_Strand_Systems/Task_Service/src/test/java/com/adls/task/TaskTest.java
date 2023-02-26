/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.adls.task.Task;
import com.adls.task.TaskService;

import static com.adls.task.TaskService.uuid;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {
    @Test
    public void createTaskIdLargerThanTen(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task("11111111111", "SetUpTask","Set up meeting with Bob");                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
        Assertions.assertEquals("Task ID cannot be longer than 10 characters", thrown.getMessage());
        System.out.println("Create TaskID Longer Than 10 - Passed");
    }

    @Test
    public void createNullTaskId(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task(null,"Set up task", "Set up meeting with Bob");
                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
            Assertions.assertEquals("Task ID cannot be null", thrown.getMessage());
            System.out.println("Create Null Task ID - Passed");
    }

    @Test
    public void createEmptyTaskId(){
    	Task t1 = new Task("","Set up task", "Set up meeting with Bob");        TaskService taskService = new TaskService();
        System.out.println(TaskService.addTask(t1));
        System.out.println("Task ID Empty String - Passed");
    }

    @Test
    public void createNameLongerThan20() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task(uuid, "SetUpMeetingForNextSaturdayNight","Set up meeting with Bob");                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
        Assertions.assertEquals("Name cannot be longer than 20 characters", thrown.getMessage());
        System.out.println("Create Name Longer Than 20 - Passed");
    }

    @Test
    public void createNullName() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task(uuid,null, "Set up meeting with Bob");                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
        Assertions.assertEquals("Name cannot be null", thrown.getMessage());
        System.out.println("Create Null Name - Passed");
    }

    @Test
    public void createDescriptionLongerThan50() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task(uuid, "SetUpTask","[Set up meeting] Bob will be very busy having meetings with many people in the office this week and next week");                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
        Assertions.assertEquals("Description cannot be longer than 50 characters", thrown.getMessage());
        System.out.println("Create Description Longer Than 50 - Passed");
    }

    @Test
    public void createNullDescription() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Task t1 = new Task(uuid,"SetUpTask", null);                    TaskService taskService = new TaskService();
                    System.out.println(TaskService.addTask(t1));
                });
        Assertions.assertEquals("Description cannot be null", thrown.getMessage());
        System.out.println("Create Null Description - Passed");
    }

    @Test
    public void testSetterAndGetter(){
        Task t1 = new Task(" ", " ", " ");
        t1.setTaskId(uuid);
        t1.setName("TestSetAndGet");
        t1.setDescription("Simple Unit Test - Passed");
        System.out.println();
        System.out.println(t1.getTaskId());
        System.out.println(t1.getName());
        System.out.println(t1.getDescription());
    }

}
