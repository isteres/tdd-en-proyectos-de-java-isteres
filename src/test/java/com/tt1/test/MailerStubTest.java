package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MailerStubTest {
    @Test
    void testEnviarAlerta() {
        MailerStub mailer = new MailerStub();
        assertThrows(UnsupportedOperationException.class, () -> {
            mailer.enviarMensaje("test@ur.es", "Mensaje de prueba");
        });
    }
} 	