package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public interface ServicioInterface {
    void crearTarea(String nombre, LocalDate fecha);
    void registrarEmail(String email);
    void completarTarea(String nombre);
    List<ToDo> listarPendientes();
}
