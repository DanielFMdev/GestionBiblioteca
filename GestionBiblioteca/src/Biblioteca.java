import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private static ArrayList<Libro> libros;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<PrestamoLibro> prestamos;

    public Biblioteca() {
        libros = new ArrayList();
        usuarios = new ArrayList();
        prestamos = new ArrayList();
    }

    public static void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarPrestamo(PrestamoLibro prestamo) {
        prestamos.add(prestamo);
    }

    public void agregarDevolucion(PrestamoLibro prestamo) {
        prestamos.remove(prestamo);
    }

    public void buscarLibro(String titulo) {
        for(Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                PrintStream var10000 = System.out;
                String var10001 = libro.getTitulo();
                var10000.println("Libro encontrado: " + var10001 + " por " + libro.getAutor() + "Número de copias disponibles: " + libro.getNumeroCopias());
                return;
            }
        }

        System.out.println("Libro no encontrado: " + titulo);
    }
}
