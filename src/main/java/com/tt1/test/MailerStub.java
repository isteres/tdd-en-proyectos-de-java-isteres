package com.tt1.test;

public class MailerStub implements MailerInterface {
    @Override
    public boolean enviarMensaje(String email, String texto) {
        if (email == null || email.isEmpty() || texto == null) {
            return false;
        }
        System.out.println("Destino: " + email);
        System.out.println("Mensaje: " + texto);
        return true;
    }
}
