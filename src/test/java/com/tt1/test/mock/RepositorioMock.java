package com.tt1.test.mock;

import com.tt1.test.RepositorioInterface;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMock implements RepositorioInterface {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    @Override
    public ToDo encontrarPorNombre(String nombre) {
        return tareas.stream()
                .filter(t -> t.getNombre() != null && t.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void marcarCompletada(String nombre) {
        ToDo tarea = encontrarPorNombre(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
        }
    }

    @Override
    public void persistirTarea(ToDo tarea) {
        tareas.removeIf(t -> t.getNombre() != null && t.getNombre().equals(tarea.getNombre()));
        tareas.add(tarea);
    }

    @Override
    public List<ToDo> listarTodas() {
        return new ArrayList<>(tareas);
    }

    @Override
    public void guardarEmail(String email) {
        emails.add(email);
    }

    @Override
    public List<String> obtenerEmails() {
        return new ArrayList<>(emails);
    }
}
