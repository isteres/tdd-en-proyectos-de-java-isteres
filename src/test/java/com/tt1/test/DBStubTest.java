package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.DBStubMock;

class DBStubTest {
    private DBStubInterface db;

    @BeforeEach
    void setUp() {
        // En este caso, DBStub es la clase base, no tiene dependencias.
        // El test unitario de DBStub usa la clase real.
        db = new DBStub();
    }

    @Test
    void testCreateAndGetTask() {
        // Nota: Como DBStub lanza UnsupportedOperationException, este test fallará
        // hasta que implementes la lógica.
        ToDo t = new ToDo();
        assertThrows(UnsupportedOperationException.class, () -> db.createTask(t));
    }
}
