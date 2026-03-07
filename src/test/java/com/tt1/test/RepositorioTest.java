package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.RepositorioMock;
import com.tt1.test.mock.DBStubMock;

class RepositorioTest {
    private Repositorio repo;
    private DBStubInterface dbMock;

    @BeforeEach
    void setUp() {
        // TEST UNITARIO: Clase Real + Dependencia Mockeada
        dbMock = new DBStubMock();
        repo = new Repositorio(dbMock);
    }

    @Test
    void testPersistirYEncontrar() {
        ToDo t = new ToDo();
        t.setNombre("Test");
        
        // El repositorio real debería usar el dbMock para persistir
        assertThrows(UnsupportedOperationException.class, () -> repo.persistirTarea(t));
    }
}
