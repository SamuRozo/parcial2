package com.miempresa.celulares;

import java.io.IOException;
import java.util.List;

public interface CelularService {
    void agregarCelular(Celular celular) throws IOException, ClassNotFoundException;
    List<Celular> listarCelulares() throws IOException, ClassNotFoundException;
    Celular buscarCelularPorId(int id) throws IOException, ClassNotFoundException;
    void actualizarCelular(Celular celular) throws IOException, ClassNotFoundException;
    void eliminarCelular(int id) throws IOException, ClassNotFoundException;
}
