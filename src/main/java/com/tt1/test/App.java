package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Aplicación ToDo ---");
        
        ServicioInterface servicio = new Servicio();
        
        System.out.println("Creando tareas...");
        servicio.crearTarea("Aprender TDD", LocalDate.now().plusDays(5));
        servicio.crearTarea("Implementar Mocks", LocalDate.now().plusDays(2));
        
        List<ToDo> pendientes = servicio.listarPendientes();
        System.out.println("Tareas pendientes: " + pendientes.size());
        for (ToDo t : pendientes) {
            System.out.println(" - " + t.getNombre() + " (Límite: " + t.getFechaLimite() + ")");
        }
        
        System.out.println("\nCompletando una tarea...");
        servicio.completarTarea("Aprender TDD");
        
        pendientes = servicio.listarPendientes();
        System.out.println("Tareas pendientes ahora: " + pendientes.size());
        
        System.out.println("\nEnviando recordatorio de prueba...");
        MailerInterface mailer = new MailerStub();
        mailer.enviarMensaje("alumno@ur.es", "Tienes tareas pendientes.");
        
        System.out.println("--- Fin de la Aplicación ---");
    }
}
