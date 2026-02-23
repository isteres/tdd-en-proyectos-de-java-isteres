package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ToDoTest {
    @Test
    void testJavaBean() {
        ToDo tarea = new ToDo();
        tarea.setNombre("Práctica 3");
        tarea.setCompletado(true);
        
        assertEquals("Práctica 3", tarea.getNombre());
        assertTrue(tarea.isCompletado());
    }
}