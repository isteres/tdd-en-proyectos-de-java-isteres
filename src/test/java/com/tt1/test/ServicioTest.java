package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.RepositorioMock;
import com.tt1.test.mock.MailerStubMock;
import java.time.LocalDate;
import java.util.List;

class ServicioTest {
    private Servicio servicio;
    private RepositorioInterface repoMock;
    private MailerInterface mailerMock;

    @BeforeEach
    void setUp() {
        // Usamos mocks para las dependencias para que sea un test unitario
        repoMock = new RepositorioMock();
        mailerMock = new MailerStubMock();
        servicio = new Servicio(repoMock, mailerMock);
    }

    @Test
    void testAñadirTarea() {
        // Arrange
        String nombre = "Nueva Tarea";
        LocalDate fecha = LocalDate.now().plusDays(1);

        // Act
        servicio.crearTarea(nombre, fecha);

        // Assert
        ToDo tarea = repoMock.encontrarPorNombre(nombre);
        assertNotNull(tarea, "La tarea debería haberse guardado en el repositorio");
        assertEquals(nombre, tarea.getNombre());
    }

    @Test
    void testAñadirDireccionCorreo() {
        // Arrange
        String email = "test@ejemplo.com";

        // Act
        servicio.registrarEmail(email);

        // Assert
        List<String> emails = repoMock.obtenerEmails();
        assertTrue(emails.contains(email), "El correo debería haberse registrado en el repositorio");
    }

    @Test
    void testMarcarTareaComoCompletada() {
        // Arrange
        String nombre = "Tarea a Completar";
        servicio.crearTarea(nombre, LocalDate.now().plusDays(1));

        // Act
        servicio.completarTarea(nombre);

        // Assert
        ToDo tarea = repoMock.encontrarPorNombre(nombre);
        assertTrue(tarea.getCompletado(), "La tarea debería estar marcada como completada");
    }

    @Test
    void testListarPendientes() {
        // Arrange
        servicio.crearTarea("Tarea 1", LocalDate.now().plusDays(1));
        servicio.crearTarea("Tarea Completada", LocalDate.now().plusDays(2));
        servicio.completarTarea("Tarea Completada");

        // Act
        List<ToDo> pendientes = servicio.listarPendientes();

        // Assert
        assertEquals(1, pendientes.size(), "Solo debería haber una tarea pendiente");
        assertEquals("Tarea 1", pendientes.get(0).getNombre());
    }
}
