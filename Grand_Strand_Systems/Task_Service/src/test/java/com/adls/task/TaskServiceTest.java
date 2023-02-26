/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.task;

import static com.adls.task.TaskService.uuid;

import org.junit.jupiter.api.Test;

import com.adls.task.Task;
import com.adls.task.TaskService;

public class TaskServiceTest {

    @Test
    public void createModifyAndDeleteTask(){
        Task t1 = new Task(uuid, "SetUpTask", "Set up meeting with Bob");
        TaskService taskService = new TaskService();
        System.out.println(taskService.addTask(t1));
        System.out.println(taskService.updateTask(uuid, "SetUpDone", "Added meeting to calendar"));
        System.out.println(taskService.deleteTask(uuid));
    }
}