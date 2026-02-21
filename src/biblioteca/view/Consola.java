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
            System.out.println("2 - Registrar Usuario");
            System.out.println("3 - Realizar Préstamo");
            System.out.println("4 - Buscar Libro");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuRegistrarLibro();
                    break;
                case 2:
                    menuRegistrarUsuario();
                    break;
                case 3:
                    menuRealizarPrestamo();
                    break;
                case 4:
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
        Genero genero = Genero.valueOf(sc.next().toUpperCase());
        System.out.print("Numero de copias: ");
        int numeroCopias = sc.nextInt();
        
        gestor.registrarLibro(isbn, titulo, autor, anioPublicacion, genero, numeroCopias);
        System.out.println("Libro registrado con éxito.");
    }

    private void menuRealizarPrestamo() {
        System.out.print("ID del Usuario: ");
        int idUsuario = sc.nextInt();
        System.out.print("ISBN del Libro a prestar: ");
        int isbn = sc.nextInt();

        try {
            gestor.realizarPrestamo(idUsuario, isbn);
            System.out.println("Préstamo realizado con éxito.");
        } catch (LibroNoDisponibleException | LimitePrestamosExcedidoException | IllegalArgumentException e) {
            System.err.println("Error al realizar préstamo: " + e.getMessage());
        }
    }

    private void menuBuscarLibro() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = sc.nextLine();
        Libro libro = gestor.buscarLibro(titulo);
        
        if(libro != null) {
            System.out.println("Encontrado: " + libro.getTitulo() + " | Autor: " + libro.getAutor() + " | Copias: " + libro.getNumeroCopias());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}