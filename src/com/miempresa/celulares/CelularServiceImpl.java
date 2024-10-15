package com.miempresa.celulares;

import java.io.IOException;
import java.util.List;

public class CelularServiceImpl implements CelularService {
    private final CelularRepository repository;

    public CelularServiceImpl(CelularRepository repository) {
        this.repository = repository;
    }

    @Override
    public void agregarCelular(Celular celular) throws IOException, ClassNotFoundException {
        repository.guardar(celular);
    }

    @Override
    public List<Celular> listarCelulares() throws IOException, ClassNotFoundException {
        return repository.listar();
    }

    @Override
    public Celular buscarCelularPorId(int id) throws IOException, ClassNotFoundException {
        return repository.buscarPorId(id);
    }

    @Override
    public void actualizarCelular(Celular celular) throws IOException, ClassNotFoundException {
        repository.actualizar(celular);
    }

    @Override
    public void eliminarCelular(int id) throws IOException, ClassNotFoundException {
        repository.eliminar(id);
    }
}
