import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;

        do {
            System.out.println("Bienvenido a la Biblioteca");
            System.out.println("1 - Registrar Libro");
            System.out.println("2 - Registrar Usuario");
            System.out.println("3 - Realizar Préstamo");
            System.out.println("4 - Realizar Devolución");
            System.out.println("5 - Buscar Libro");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Titulo del libro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = sc.nextLine();
                    System.out.print("Año de publicación: ");
                    int anioPublicacion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Género del libro (FICCION, NO_FICCION, CIENCIA_FICCION, FANTASIA, HISTORIA, BIOGRAFIA, POESIA, TEATRO): ");
                    Genero genero = Genero.valueOf(sc.next().toUpperCase());
                    System.out.print("Numero de copias: ");
                    int numeroCopias = sc.nextInt();
                    sc.nextLine();
                    Biblioteca.agregarLibro(new Libro(titulo, autor, anioPublicacion, genero, numeroCopias));
                    break;
                case 2:
                    System.out.print("Nombre del usuario: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email del usuario: ");
                    String email = sc.nextLine();
                    Biblioteca.agregarUsuario(new Usuario(nombre, email));
                case 3:
                case 4:
                    break;
                case 5:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String tituloBusqueda = sc.nextLine();
                    biblioteca.buscarLibro(tituloBusqueda);
                    break;
                case 6:
                    System.out.println("Gracias por usar la Biblioteca. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while(opcion != 0);

    }
}
