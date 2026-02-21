package biblioteca.exceptions;

//Muestra un mensaje si el libro no esta disponible (sea para prestamo o porque se haya retirado)
public class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}