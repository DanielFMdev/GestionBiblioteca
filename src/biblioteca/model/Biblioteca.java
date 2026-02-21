package biblioteca.model;
import java.io.PrintStream;
import java.util.ArrayList;

import biblioteca.model.Libro;
import biblioteca.model.PrestamoLibro;
import biblioteca.model.Usuario;

public class Biblioteca {
    // CORRECCIÓN: Quitamos el 'static' para instanciar la biblioteca correctamente
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<PrestamoLibro> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro){ 
        libros.add(libro); 
    }
    public void agregarUsuario(Usuario usuario){ 
        usuarios.add(usuario); 
    }
    public void agregarPrestamo(PrestamoLibro prestamo){ 
        prestamos.add(prestamo); 
    }
    
    // CORRECCIÓN: Devuelve el objeto, no imprime por pantalla (más profesional)
    public Libro buscarLibro(String titulo) {
        for(Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Si no lo encuentra
    }

    public Libro buscarLibroPorISBN(int isbn) {
        for(Libro libro : libros) {
            if (libro.getISBN() == isbn) return libro;
        }
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for(Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}