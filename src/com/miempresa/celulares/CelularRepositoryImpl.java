
package com.miempresa.celulares;

import java.io.*;
        import java.util.ArrayList;
import java.util.List;

public class CelularRepositoryImpl implements CelularRepository {
    private final String archivo;

    public CelularRepositoryImpl(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void guardar(Celular celular) throws IOException {
        List<Celular> celulares = listar();
        celulares.add(celular);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(celulares);
        }
    }

    @Override
    public List<Celular> listar() throws IOException, ClassNotFoundException {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Celular>) ois.readObject();
        }
    }

    @Override
    public Celular buscarPorId(int id) throws IOException, ClassNotFoundException {
        List<Celular> celulares = listar();
        return celulares.stream()
                .filter(celular -> celular.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Celular celularActualizado) throws IOException, ClassNotFoundException {
        List<Celular> celulares = listar();
        for (int i = 0; i < celulares.size(); i++) {
            if (celulares.get(i).getId() == celularActualizado.getId()) {
                celulares.set(i, celularActualizado);
                break;
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(celulares);
        }
    }

    @Override
    public void eliminar(int id) throws IOException, ClassNotFoundException {
        List<Celular> celulares = listar();
        celulares.removeIf(celular -> celular.getId() == id);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(celulares);
        }
    }
}
