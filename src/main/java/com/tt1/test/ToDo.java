package com.tt1.test;

import java.time.LocalDate;
import java.io.Serializable;

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    // Constructor vacío (Requisito JavaBean)
    public ToDo() {}

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}