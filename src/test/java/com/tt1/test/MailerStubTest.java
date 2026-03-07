package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.mock.MailerStubMock;

class MailerStubTest {
    private MailerInterface mailer;
    private static final boolean USE_MOCK = true;

    @BeforeEach
    void setUp() {
        if (USE_MOCK) {
            mailer = new MailerStubMock();
        } else {
            mailer = new MailerStub();
        }
    }

    @Test
    void testEnviarMensajeExito() {
        boolean resultado = mailer.enviarMensaje("test@ur.es", "Mensaje");
        assertTrue(resultado);
    }
}
