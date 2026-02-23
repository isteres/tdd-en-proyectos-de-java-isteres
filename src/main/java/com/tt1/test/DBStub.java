package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    public void createTask(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> getTask() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void deleteTask(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void updateTast(ToDo tarea) {
    	throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}