package biblioteca.model;
public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private Genero genero;
    private EstadoLibro estado;
    private boolean disponibleParaPrestamo;
    private int numeroCopias;

    // CORRECCIÓN: Añadimos ISBN al constructor
    public Libro(int ISBN, String titulo, String autor, int anioPublicacion, Genero genero, int numeroCopias) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.estado = EstadoLibro.DISPONIBLE;
        this.disponibleParaPrestamo = true;
        this.numeroCopias = numeroCopias;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnioPublicacion() {
        return this.anioPublicacion;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public EstadoLibro getEstado() {
        return this.estado;
    }

    public boolean isDisponibleParaPrestamo() {
        return this.disponibleParaPrestamo;
    }

    public int getNumeroCopias() {
        return this.numeroCopias;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public void setDisponibleParaPrestamo(boolean disponibleParaPrestamo) {
        this.disponibleParaPrestamo = disponibleParaPrestamo;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }
}
