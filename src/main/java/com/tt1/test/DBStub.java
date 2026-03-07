package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub implements DBStubInterface {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    @Override
    public void createTask(ToDo tarea) {
        tareas.add(tarea);
    }

    @Override
    public List<ToDo> getTask() {
        return new ArrayList<>(tareas);
    }

    @Override
    public void deleteTask(ToDo tarea) {
        tareas.removeIf(t -> t.getNombre().equals(tarea.getNombre()));
    }

    @Override
    public void updateTask(ToDo tarea) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getNombre().equals(tarea.getNombre())) {
                tareas.set(i, tarea);
                break;
            }
        }
    }
    
    @Override
    public void registerEmail(String mail) {
        if (!agendaEmails.contains(mail)) {
            agendaEmails.add(mail);
        }
    }

    @Override
    public List<String> getEmails(){
        return new ArrayList<>(agendaEmails);
    }
}
