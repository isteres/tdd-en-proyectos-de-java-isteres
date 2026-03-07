package com.tt1.test;

import java.time.LocalDate;

public interface ToDoInterface {
    String getNombre();
    void setNombre(String nombre);
    String getDescripcion();
    void setDescripcion(String descripcion);
    LocalDate getFechaLimite();
    void setFechaLimite(LocalDate fechaLimite);
    boolean getCompletado();
    void setCompletado(boolean completado);
}
