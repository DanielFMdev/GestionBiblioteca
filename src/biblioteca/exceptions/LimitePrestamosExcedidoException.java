package biblioteca.exceptions;

//Muestra un mensaje si se ha excedido el limite de prestamos de libros
public class LimitePrestamosExcedidoException extends Exception {
    public LimitePrestamosExcedidoException(String mensaje) {
        super(mensaje);
    }
}