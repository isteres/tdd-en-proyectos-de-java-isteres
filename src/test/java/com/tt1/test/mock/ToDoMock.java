package com.tt1.test.mock;

import com.tt1.test.ToDoInterface;
import java.time.LocalDate;

public class ToDoMock implements ToDoInterface {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    @Override public String getNombre() { return nombre; }
    @Override public void setNombre(String nombre) { this.nombre = nombre; }
    @Override public String getDescripcion() { return descripcion; }
    @Override public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    @Override public LocalDate getFechaLimite() { return fechaLimite; }
    @Override public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    @Override public boolean getCompletado() { return completado; }
    @Override public void setCompletado(boolean completado) { this.completado = completado; }
}
