/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.task;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.adls.task.Task.*;

public class TaskService {
    public static final String uuid = RandomStringUtils.random(uuidLength, letters, numbers);

    private static Map<String, Task> tasks = new HashMap<String, Task>();

    public static Map<String, Task> addTask(Task task) {
        String uuid = TaskService.uuid;
        tasks.put(uuid, task);
        return tasks;
    }

    public static Map<String, Task> deleteTask(String taskId) {
        Iterator itr = tasks.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Integer, Task> entry = (Map.Entry<Integer, Task>) itr.next();
            if (entry.getValue().getTaskId() == taskId) {
                itr.remove();
            }
        }
        return tasks;
    }

    public static Map<String, Task> updateTask(String taskId, String name, String description) {
        Iterator itr = tasks.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Integer, Task> entry = (Map.Entry<Integer, Task>) itr.next();
            if(entry.getValue().getTaskId() == taskId) {
                entry.getValue().setDescription(description);
                entry.getValue().setName(name);
            }
        }
        return tasks;
    }
}
