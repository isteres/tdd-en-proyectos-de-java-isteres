package com.tt1.test;

import java.util.List;

public interface RepositorioInterface {
    ToDo encontrarPorNombre(String nombre);
    void marcarCompletada(String nombre);
    void persistirTarea(ToDo tarea);
    List<ToDo> listarTodas();
    void guardarEmail(String email);
    List<String> obtenerEmails();

}
