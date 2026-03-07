package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.ToDoMock;

class ToDoTest {
    private ToDoInterface tarea;
    private static final boolean USE_MOCK = true;

    @BeforeEach
    void setUp() {
        if (USE_MOCK) {
            tarea = new ToDoMock();
        } else {
            tarea = new ToDo();
        }
    }

    @Test
    void testToDo() {
        tarea.setNombre("Práctica 3");
        tarea.setCompletado(true);
        
        assertEquals("Práctica 3", tarea.getNombre());
        assertTrue(tarea.getCompletado());
    }
}
