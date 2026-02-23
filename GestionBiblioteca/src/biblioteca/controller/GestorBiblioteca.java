package biblioteca.controller;

import biblioteca.model.*;
import biblioteca.exceptions.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    // CORRECCIÓN: Método de devolución implementado
    public void devolverPrestamo(int idUsuario, int isbn) throws LibroNoDisponibleException {
        Usuario usuario = biblioteca.buscarUsuarioPorId(idUsuario);
        Libro libro = biblioteca.buscarLibroPorISBN(isbn);

        // Validamos que el usuario y el libro existan en el sistema
        if (usuario == null || libro == null) {
            throw new IllegalArgumentException("Usuario o Libro no encontrados en el sistema.");
        }

        // Buscamos el préstamo activo del libro para el usuario
        PrestamoLibro prestamoActivo = null;
        for (PrestamoLibro p : usuario.getLibrosPrestados()) {
            if (p.getLibro().getISBN() == isbn) {
                prestamoActivo = p;
                break;
            }
        }

        // Si no se encuentra un préstamo activo, se lanza una excepción
        if (prestamoActivo == null) {
            throw new LibroNoDisponibleException(
                    "El usuario " + usuario.getNombre() +
                            " no tiene prestado el libro '" + libro.getTitulo() + "'.");
        }

        // Actualizamos la fecha de devolución y movemos el préstamo al historial
        prestamoActivo.setFechaDevolucion(LocalDate.now());
        usuario.getLibrosPrestados().remove(prestamoActivo);
        usuario.getHistorialPrestamos().add(prestamoActivo);

        // Actualizamos el número de copias del libro y su estado si es necesario
        libro.setNumeroCopias(libro.getNumeroCopias() + 1);
        if (libro.getEstado() == EstadoLibro.PRESTADO) {
            libro.setEstado(EstadoLibro.DISPONIBLE);
        }
    }

    // Métodos delegados para que la Vista no hable con el Modelo directamente
    public void registrarUsuario(String nombre, String email) {
        biblioteca.agregarUsuario(new Usuario(nombre, email));
    }

    // Metodo para mostrar a los usuarios registrados
    public void mostrarUsuarios() {
        ArrayList<Usuario> usuarios = biblioteca.getUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() + " | Email: " + u.getEmail() +
                    " | Libros prestados: " + u.getLibrosPrestados());
        }
    }

    public void registrarLibro(int isbn, String titulo, String autor, int anio, Genero genero, int copias) {
        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, anio, genero, copias));
    }

    // Metodo para mostrar los libros registrados
    public void mostrarLibros() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println("Título: " + l.getTitulo() + " | Autor: " + l.getAutor() +
                    " | Año de publicación: " + l.getAnioPublicacion() + " | Genero: " + l.getGenero() +
                    " | Estado: "  + l.getEstado() + " | Copias: " + l.getNumeroCopias());
        }
    }

    // Metodos para buscar los libros por ISBN, Titulo o Genero
    public Libro buscarLibroPorTitulo(String titulo) {
        return biblioteca.buscarLibroPorTitulo(titulo);
    }

    public Libro buscarLibroPorISBN(int isbn) {
        return biblioteca.buscarLibroPorISBN(isbn);
    }

    public Libro buscarLibroPorGenero(String genero) {
        return biblioteca.buscarLibroPorGenero(genero);
    }
}