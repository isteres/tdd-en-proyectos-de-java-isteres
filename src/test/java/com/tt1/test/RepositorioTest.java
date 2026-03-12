package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class RepositorioTest {
    private Repositorio repo;
    private DBStubInterface db;

    @BeforeEach
    void setUp() {
        // En este caso usamos DBStub (la implementación real en memoria)
        // para asegurar que el repositorio funciona correctamente con ella.
        db = new DBStub();
        repo = new Repositorio(db);
    }

    @Test
    void testPersistirYEncontrar() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("Tarea Test");
        
        // Act
        repo.persistirTarea(t);
        ToDo encontrada = repo.encontrarPorNombre("Tarea Test");
        
        // Assert
        assertNotNull(encontrada, "La tarea debería haberse guardado y encontrado");
        assertEquals("Tarea Test", encontrada.getNombre());
    }

    @Test
    void testMarcarCompletada() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("Tarea Incompleta");
        t.setCompletado(false);
        repo.persistirTarea(t);
        
        // Act
        repo.marcarCompletada("Tarea Incompleta");
        ToDo encontrada = repo.encontrarPorNombre("Tarea Incompleta");
        
        // Assert
        assertTrue(encontrada.getCompletado(), "La tarea debería estar marcada como completada");
    }

    @Test
    void testListarTodas() {
        // Arrange
        ToDo t1 = new ToDo();
        t1.setNombre("Tarea 1");
        ToDo t2 = new ToDo();
        t2.setNombre("Tarea 2");
        repo.persistirTarea(t1);
        repo.persistirTarea(t2);
        
        // Act
        List<ToDo> todas = repo.listarTodas();
        
        // Assert
        assertEquals(2, todas.size(), "Debería haber exactamente 2 tareas");
    }

    @Test
    void testGuardarYObtenerEmails() {
        // Arrange
        String email = "usuario@test.com";
        
        // Act
        repo.guardarEmail(email);
        List<String> emails = repo.obtenerEmails();
        
        // Assert
        assertTrue(emails.contains(email), "El email debería estar en la lista de emails registrados");
    }

    @Test
    void testEncontrarPorNombreNoExistente() {
        // Act
        ToDo encontrada = repo.encontrarPorNombre("Inexistente");
        
        // Assert
        assertNull(encontrada, "Debería devolver null si la tarea no existe");
    }
}
