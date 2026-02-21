# 📚 Sistema de Gestión de Biblioteca (Java MVC)
Este proyecto es una aplicación de consola desarrollada en Java para la asignatura de Programación. El objetivo es gestionar de manera eficiente el inventario de una biblioteca, los registros de usuarios y el flujo de préstamos y devoluciones.

# 🛠️ Características Principales
La aplicación permite realizar las siguientes acciones:

Gestión de Inventario: Registro y búsqueda de libros por título e ISBN.

Control de Usuarios: Registro de socios con identificadores únicos.

Sistema de Préstamos: Lógica avanzada que permite controlar el stock de copias y límites de usuario.

Reglas de Negocio: * Límite de 3 libros por usuario.

Validación de disponibilidad en tiempo real.

Cálculo automático de fechas de vencimiento.

# 🏗️ Arquitectura del Proyecto (MVC)
El código está organizado siguiendo el patrón de diseño Modelo-Vista-Controlador, lo que garantiza un código limpio, escalable y fácil de mantener:

📂 biblioteca.model: Contiene las entidades de datos (Libro, Usuario, PrestamoLibro) y los Enums.

📂 biblioteca.controller: El "cerebro" que aplica las reglas de negocio y comunica la vista con los datos.

📂 biblioteca.view: Interfaz de usuario por consola para interactuar con el sistema.

📂 biblioteca.exceptions: Excepciones personalizadas para un manejo de errores robusto.

📂 biblioteca.app: Punto de entrada de la aplicación (Main).

# 🚀 Cómo ejecutar el programa
1. Asegúrate de tener instalado el JDK 17 o superior.

2. Clona este repositorio: git clone https://github.com/DanielFMdev/GestionBiblioteca.git

3. Compila y ejecuta la clase Main.java desde tu IDE favorito (IntelliJ, Eclipse, VS Code).

# 💻 Tecnologías utilizadas
Lenguaje: Java ☕

Control de Versiones: Git & GitHub

Arquitectura: Pattern MVC

# 👥 Desarrolladores
Este proyecto ha sido desarrollado por:

Daniel Flores Medina
DanielFMdev - GitHub Profile

Fabián González Olofsson
FabiTheo1 - GitHub Profile
