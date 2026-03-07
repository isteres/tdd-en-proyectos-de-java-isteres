package com.tt1.test.mock;

import com.tt1.test.DBStubInterface;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class DBStubMock implements DBStubInterface {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    @Override
    public void createTask(ToDo tarea) {
        tareas.add(tarea);
    }

    @Override
    public List<ToDo> getTask() {
        return tareas;
    }

    @Override
    public void deleteTask(ToDo tarea) {
        tareas.remove(tarea);
    }

    @Override
    public void updateTask(ToDo tarea) {
        // Mock update logic
    }

    @Override
    public void registerEmail(String mail) {
        emails.add(mail);
    }

    @Override
    public List<String> getEmails() {
        return emails;
    }
}
