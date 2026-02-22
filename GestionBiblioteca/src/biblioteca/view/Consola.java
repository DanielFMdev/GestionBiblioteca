package biblioteca.view;

import biblioteca.controller.GestorBiblioteca;
import biblioteca.model.Genero;
import biblioteca.model.Libro;
import biblioteca.exceptions.*;
import java.util.Scanner;

public class Consola {
    private GestorBiblioteca gestor;
    private Scanner sc;

    public Consola(GestorBiblioteca gestor) {
        this.gestor = gestor;
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n--- BIENVENIDO A LA BIBLIOTECA ---");
            System.out.println("1 - Registrar Libro");
            System.out.println("2 - Listar Libros");
            System.out.println("3 - Registrar Usuario");
            System.out.println("4 - Listar Usuarios");
            System.out.println("5 - Realizar Préstamo");
            System.out.println("6 - Devolver Préstamo");
            System.out.println("7 - Buscar Libro");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuRegistrarLibro();
                    break;
                case 2:
                    menuMostrarLibro();
                    break;
                case 3:
                    menuRegistrarUsuario();
                    break;
                case 4:
                    menuMostrarUsuario();
                    break;
                case 5:
                    menuRealizarPrestamo();
                    break;
                case 6:
                    menuDevolverPrestamo();
                    break;
                case 7:
                    menuBuscarLibro();
                    break;
                case 0:
                    System.out.println("Gracias por usar la Biblioteca. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void menuRegistrarUsuario() {
        System.out.print("Nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Email del usuario: ");
        String email = sc.nextLine();
        gestor.registrarUsuario(nombre, email);
        System.out.println("Usuario registrado con éxito.");
    }

    // Se añade un menú para mostrar a los usuarios
    private void menuMostrarUsuario() {
        gestor.mostrarUsuarios();
    }

    private void menuRegistrarLibro() {
        System.out.print("ISBN: ");
        int isbn = sc.nextInt();
        sc.nextLine();
        System.out.print("Titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anioPublicacion = sc.nextInt();
        sc.nextLine();
        System.out.print("Género (FICCION, NO_FICCION, CIENCIA_FICCION...): ");
        Genero genero = Genero.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Numero de copias: ");
        int numeroCopias = sc.nextInt();
        
        gestor.registrarLibro(isbn, titulo, autor, anioPublicacion, genero, numeroCopias);
        System.out.println("Libro registrado con éxito.");
    }

    private void menuMostrarLibro() {
        gestor.mostrarLibros();
    }

    private void menuRealizarPrestamo() {
        System.out.print("ID del Usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        System.out.print("ISBN del Libro a prestar: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        try {
            gestor.realizarPrestamo(idUsuario, isbn);
            System.out.println("Préstamo realizado con éxito.");
        } catch (LibroNoDisponibleException | LimitePrestamosExcedidoException | IllegalArgumentException e) {
            System.err.println("Error al realizar préstamo: " + e.getMessage());
        }
    }

    // Se corrige el método para devolver un préstamo, ahora se pide el ID del usuario y el ISBN del libro a devolver
    private void menuDevolverPrestamo() {
        System.out.print("ID del Usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        System.out.print("ISBN del Libro a devolver: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        try {
            gestor.devolverPrestamo(idUsuario, isbn);
            System.out.println("Préstamo devuelto con éxito.");
        } catch (LibroNoDisponibleException | IllegalArgumentException e) {
            System.err.println("Error al devolver préstamo: " + e.getMessage());
        }
    }

    // Se corrige las formas de buscar libro
    private void menuBuscarLibro() {
        System.out.println("Como quiere buscar el libro: ");
        System.out.println("1 - Titulo del libro");
        System.out.println("2 - ISBN del libro");
        System.out.println("3 - Genero del libro");
        System.out.print("Ingrese una opcion: ");
        int buscarLibro = sc.nextInt();
        sc.nextLine();

        if (buscarLibro == 1) {
            System.out.print("Ingrese el título del libro a buscar: ");
            String titulo = sc.nextLine();

            Libro libro = gestor.buscarLibroPorTitulo(titulo);

            if(libro != null) {
                System.out.println("Encontrado: " + libro.getTitulo() + " | Autor: " + libro.getAutor() +
                        " | Género: " + libro.getGenero() + " | Copias: " + libro.getNumeroCopias());
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else if (buscarLibro == 2) {
            System.out.print("Ingrese el ISBN del libro a buscar: ");
            int isbn = sc.nextInt();
            sc.nextLine();
            Libro libro = gestor.buscarLibroPorISBN(isbn);

            if(libro != null) {
                System.out.println("Encontrado: " + libro.getTitulo() + " | Autor: " + libro.getAutor() +
                        " | Género: " + libro.getGenero() + " | Copias: " + libro.getNumeroCopias());
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else if (buscarLibro == 3) {
            System.out.print("Ingrese el genero del libro a buscar: ");
            String genero = sc.nextLine().toUpperCase();
            Libro libro = gestor.buscarLibroPorGenero(genero);

            if(libro != null) {
                System.out.println("Encontrado: " + libro.getTitulo() + " | Autor: " + libro.getAutor() +
                        " | Género: " + libro.getGenero() + " | Copias: " + libro.getNumeroCopias());
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else {
            System.out.println("Opción no permitida");
        }
    }
}