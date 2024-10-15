package com.miempresa.celulares;

import java.io.IOException;
import java.util.List;

public interface CelularRepository {
    void guardar(Celular celular) throws IOException;
    List<Celular> listar() throws IOException, ClassNotFoundException;
    Celular buscarPorId(int id) throws IOException, ClassNotFoundException;
    void actualizar(Celular celular) throws IOException, ClassNotFoundException;
    void eliminar(int id) throws IOException, ClassNotFoundException;
}
