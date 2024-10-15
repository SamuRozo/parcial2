package com.miempresa.celulares;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CelularRepository repository = new CelularRepositoryImpl("celulares.dat");
        CelularService service = new CelularServiceImpl(repository);

        try {
            // Agregar celulares
            service.agregarCelular(new Celular(1, "Samsung", "Galaxy S21"));
            service.agregarCelular(new Celular(2, "Apple", "iPhone 13"));
            service.agregarCelular(new Celular(3, "Xiaomi", "Mi 11"));

            // Listar celulares
            List<Celular> celulares = service.listarCelulares();
            celulares.forEach(System.out::println);

            // Buscar por ID
            System.out.println("Buscar por ID 2: " + service.buscarCelularPorId(2));

            // Actualizar celular
            service.actualizarCelular(new Celular(2, "Apple", "iPhone 14"));
            System.out.println("Después de actualizar:");
            service.listarCelulares().forEach(System.out::println);

            // Eliminar celular
            service.eliminarCelular(1);
            System.out.println("Después de eliminar:");
            service.listarCelulares().forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
