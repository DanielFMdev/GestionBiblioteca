package biblioteca.app;

import biblioteca.model.Biblioteca;
import biblioteca.controller.GestorBiblioteca;
import biblioteca.view.Consola;

public class Main {
    public static void main(String[] args) {
        // Inicializa la base de datos (Model)
        Biblioteca biblioteca = new Biblioteca();
        
        // Inicializa la lógica (Controller)
        GestorBiblioteca gestor = new GestorBiblioteca(biblioteca);
        
        // Inicializa la interfaz (View)
        Consola consola = new Consola(gestor);
        
        // Arrancar la aplicación
        consola.iniciar();
    }
}