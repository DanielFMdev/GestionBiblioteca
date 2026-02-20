import java.util.ArrayList;

public class Usuario {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String email;
    private ArrayList<PrestamoLibro> librosPrestados;
    private ArrayList<PrestamoLibro> historialPrestamos;

    public Usuario(String nombre, String email) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.email = email;
        this.librosPrestados = this.librosPrestados;
        this.historialPrestamos = this.historialPrestamos;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<PrestamoLibro> getLibrosPrestados() {
        return this.librosPrestados;
    }

    public ArrayList<PrestamoLibro> getHistorialPrestamos() {
        return this.historialPrestamos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLibrosPrestados(ArrayList<PrestamoLibro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public void setHistorialPrestamos(ArrayList<PrestamoLibro> historialPrestamos) {
        this.historialPrestamos = historialPrestamos;
    }
}
