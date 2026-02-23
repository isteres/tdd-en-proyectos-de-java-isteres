package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {
    private Repositorio repositorio;
    private MailerStub mailer;

    public void crearTarea(String nombre, LocalDate fecha) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void registrarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void completarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> listarPendientes() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}