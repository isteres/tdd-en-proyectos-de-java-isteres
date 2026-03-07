package com.tt1.test.mock;

import com.tt1.test.ServicioInterface;
import com.tt1.test.ToDo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioMock implements ServicioInterface {
    private List<ToDo> tareasPendientes = new ArrayList<>();
    private List<String> emailsRegistrados = new ArrayList<>();

    @Override
    public void crearTarea(String nombre, LocalDate fecha) {
        ToDo t = new ToDo();
        t.setNombre(nombre);
        t.setFechaLimite(fecha);
        tareasPendientes.add(t);
    }

    @Override
    public void registrarEmail(String email) {
        emailsRegistrados.add(email);
    }

    @Override
    public void completarTarea(String nombre) {
        tareasPendientes.removeIf(t -> t.getNombre().equals(nombre));
    }

    @Override
    public List<ToDo> listarPendientes() {
        return tareasPendientes;
    }
}
