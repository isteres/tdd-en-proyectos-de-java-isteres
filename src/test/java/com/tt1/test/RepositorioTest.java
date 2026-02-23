package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositorioTest {
    private Repositorio repo;

    @BeforeEach
    void setUp() { repo = new Repositorio(); }

    @Test
    void testBuscarTarea() {
        assertThrows(UnsupportedOperationException.class, () -> {
            repo.encontrarPorNombre("Tarea 1");
        });
    }
}