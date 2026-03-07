package com.tt1.test.mock;

import com.tt1.test.MailerInterface;
import java.util.ArrayList;
import java.util.List;

public class MailerStubMock implements MailerInterface {
    private boolean result = true;
    private List<String> destinatariosLlamados = new ArrayList<>();
    private int mensajesEnviados = 0;

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public boolean enviarMensaje(String email, String texto) {
        this.mensajesEnviados++;
        this.destinatariosLlamados.add(email);
        System.out.println("[MOCK] Enviando mensaje a " + email + ": " + texto);
        return result;
    }

    // Métodos para verificación
    public int getMensajesEnviados() {
        return mensajesEnviados;
    }

    public List<String> getDestinatariosLlamados() {
        return destinatariosLlamados;
    }

    public boolean fueLlamadoCon(String email) {
        return destinatariosLlamados.contains(email);
    }
}
