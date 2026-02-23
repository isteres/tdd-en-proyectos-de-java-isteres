package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ServicioTest {

    private Servicio servicio;

    @BeforeEach
    void setUp() {
        // ARRANGE (Preparar): Se ejecuta antes de cada @Test.
        // Instanciamos la clase Servicio para que esté limpia en cada prueba.
        servicio = new Servicio();
    }

    @AfterEach
    void tearDown() {
        // LIMPIEZA: Se ejecuta después de cada @Test.
        // Liberamos la memoria (útil en proyectos más grandes).
        servicio = null;
    }

    @Test
    void testCrearTarea() {
        // ACT & ASSERT: Ejecutamos la acción y comprobamos el resultado esperado.
        // Como aún no hay lógica, esperamos que lance la excepción.
        assertThrows(UnsupportedOperationException.class, () -> {
            servicio.crearTarea("Aprender JUnit", LocalDate.now().plusDays(2));
        }, "Debería lanzar UnsupportedOperationException al crear la tarea");
    }

    @Test
    void testRegistrarEmail() {
        assertThrows(UnsupportedOperationException.class, () -> {
            servicio.registrarEmail("usuario@ejemplo.com");
        }, "Debería lanzar UnsupportedOperationException al registrar un email");
    }

    @Test
    void testCompletarTarea() {
        assertThrows(UnsupportedOperationException.class, () -> {
            servicio.completarTarea("Aprender JUnit");
        }, "Debería lanzar UnsupportedOperationException al completar la tarea");
    }

    @Test
    void testListarPendientes() {
        assertThrows(UnsupportedOperationException.class, () -> {
            servicio.listarPendientes();
        }, "Debería lanzar UnsupportedOperationException al listar pendientes");
    }
} 