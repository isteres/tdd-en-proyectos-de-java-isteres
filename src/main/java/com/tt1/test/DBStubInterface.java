package com.tt1.test;

import java.util.List;

public interface DBStubInterface {
    void createTask(ToDo tarea);
    List<ToDo> getTask();
    void deleteTask(ToDo tarea);
    void updateTask(ToDo tarea);
    void registerEmail(String mail);
    List<String> getEmails();
}
