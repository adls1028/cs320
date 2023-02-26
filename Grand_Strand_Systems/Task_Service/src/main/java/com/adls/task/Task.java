/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.task;

public class Task {

    private String taskId;
    private String name;
    private String description;
    static boolean numbers = true;
    static boolean letters = true;
    public static int uuidLength = 10;
    private int nameLength = 20;
    private int descriptionLength = 50;

    public Task(String taskId, String name, String description) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        else if (taskId.length() > uuidLength) {
            throw new IllegalArgumentException("Task ID cannot be longer than " + uuidLength + " characters");
        }
        else {
            this.taskId = taskId;
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        else if (name.length() > nameLength) {
            throw new IllegalArgumentException("Name cannot be longer than " + nameLength + " characters");
        }
        else {
            this.name = name;
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
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "["+taskId+","+name+","+description+"]";
    }
}