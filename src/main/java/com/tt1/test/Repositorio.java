package com.tt1.test;

import java.util.List;

public class Repositorio implements RepositorioInterface {
    private final DBStubInterface db;

    public Repositorio(DBStubInterface db) {
        this.db = db;
    }

    public Repositorio() {
        this.db = new DBStub();
    }

    @Override
    public ToDo encontrarPorNombre(String nombre) {
        if (nombre == null) return null;
        return db.getTask().stream()
                .filter(t -> nombre.equals(t.getNombre()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void marcarCompletada(String nombre) {
        ToDo t = encontrarPorNombre(nombre);
        if (t != null) {
            t.setCompletado(true);
            db.updateTask(t);
        }
    }

    @Override
    public void persistirTarea(ToDo tarea) {
        if (tarea != null) {
            db.createTask(tarea);
        }
    }

    @Override
    public List<ToDo> listarTodas() {
        return db.getTask();
    }

    @Override
    public void guardarEmail(String email) {
        db.registerEmail(email);
    }

    @Override
    public List<String> obtenerEmails() {
        return db.getEmails();
    }
}
