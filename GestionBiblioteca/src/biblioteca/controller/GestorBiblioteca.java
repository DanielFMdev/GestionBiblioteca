package biblioteca.controller;

import biblioteca.model.*;
import biblioteca.exceptions.*;
import java.time.LocalDate;

public class GestorBiblioteca {
    private Biblioteca biblioteca;

    public GestorBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void realizarPrestamo(int idUsuario, int isbn) throws LibroNoDisponibleException, LimitePrestamosExcedidoException {
        Usuario usuario = biblioteca.buscarUsuarioPorId(idUsuario);
        Libro libro = biblioteca.buscarLibroPorISBN(isbn);

        if (usuario == null || libro == null) {
            throw new IllegalArgumentException("Usuario o Libro no encontrados en el sistema.");
        }

        // Regla de negocio 1: Máximo 3 libros
        if (usuario.getLibrosPrestados().size() >= 3) {
            throw new LimitePrestamosExcedidoException("El usuario " + usuario.getNombre() + " ya tiene el máximo de 3 libros prestados.");
        }

        // Regla de negocio 2: El libro debe estar disponible y tener copias
        if (libro.getEstado() != EstadoLibro.DISPONIBLE || libro.getNumeroCopias() <= 0) {
            throw new LibroNoDisponibleException("El libro '" + libro.getTitulo() + "' no está disponible actualmente.");
        }

        // Lógica del préstamo
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaVencimiento = fechaHoy.plusDays(30);

        PrestamoLibro nuevoPrestamo = new PrestamoLibro(usuario, libro, fechaHoy, null, fechaVencimiento);
        
        // Actualizamos los datos
        libro.setNumeroCopias(libro.getNumeroCopias() - 1);
        if (libro.getNumeroCopias() == 0) {
            libro.setEstado(EstadoLibro.PRESTADO);
        }
        
        usuario.getLibrosPrestados().add(nuevoPrestamo);
        biblioteca.agregarPrestamo(nuevoPrestamo);
    }

    // Métodos delegados para que la Vista no hable con el Modelo directamente
    public void registrarUsuario(String nombre, String email) {
        biblioteca.agregarUsuario(new Usuario(nombre, email));
    }

    public void registrarLibro(int isbn, String titulo, String autor, int anio, Genero genero, int copias) {
        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, anio, genero, copias));
    }

    public Libro buscarLibro(String titulo) {
        return biblioteca.buscarLibro(titulo);
    }
}