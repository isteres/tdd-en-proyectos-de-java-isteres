package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class DBStubTest {
    private DBStubInterface db;

    @BeforeEach
    void setUp() {
        // Test unitario de la clase real DBStub (almacenamiento en memoria)
        db = new DBStub();
    }

    @Test
    void testCreateAndGetTask() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("Tarea DB");
        
        // Act
        db.createTask(t);
        List<ToDo> tareas = db.getTask();
        
        // Assert
        assertEquals(1, tareas.size(), "Debería haber una tarea en la DB");
        assertEquals("Tarea DB", tareas.get(0).getNombre());
    }

    @Test
    void testUpdateTask() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("Original");
        t.setCompletado(false);
        db.createTask(t);
        
        // Act
        t.setCompletado(true);
        db.updateTask(t);
        
        // Assert
        ToDo actualizada = db.getTask().get(0);
        assertTrue(actualizada.getCompletado(), "La tarea debería estar actualizada en la DB");
    }

    @Test
    void testDeleteTask() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("Para Borrar");
        db.createTask(t);
        assertEquals(1, db.getTask().size());
        
        // Act
        db.deleteTask(t);
        
        // Assert
        assertEquals(0, db.getTask().size(), "La tarea debería haber sido eliminada");
    }

    @Test
    void testRegisterAndGetEmails() {
        // Arrange
        String mail = "test@db.com";
        
        // Act
        db.registerEmail(mail);
        List<String> emails = db.getEmails();
        
        // Assert
        assertTrue(emails.contains(mail), "El email debería estar registrado en la DB");
    }

    @Test
    void testRegisterDuplicateEmail() {
        // Arrange
        String mail = "repetido@test.com";
        db.registerEmail(mail);
        
        // Act
        db.registerEmail(mail);
        
        // Assert
        assertEquals(1, db.getEmails().size(), "No debería registrar emails duplicados");
    }
}
