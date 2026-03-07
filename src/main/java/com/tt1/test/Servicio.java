package com.tt1.test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Servicio implements ServicioInterface {
    private final RepositorioInterface repositorio;
    private final MailerInterface mailer;

    public Servicio(RepositorioInterface repositorio, MailerInterface mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public Servicio() {
        this.repositorio = new Repositorio();
        this.mailer = new MailerStub();
    }

    @Override
    public void crearTarea(String nombre, LocalDate fecha) {
        ToDo t = new ToDo();
        t.setNombre(nombre);
        t.setFechaLimite(fecha);
        t.setCompletado(false);
        repositorio.persistirTarea(t);
    }

    @Override
    public void registrarEmail(String email) {
        repositorio.guardarEmail(email);
    }

    @Override
    public void completarTarea(String nombre) {
        repositorio.marcarCompletada(nombre);
    }

    @Override
    public List<ToDo> listarPendientes() {
        return repositorio.listarTodas().stream()
                .filter(t -> !t.getCompletado())
                .collect(Collectors.toList());
    }
}
