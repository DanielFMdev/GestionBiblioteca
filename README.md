# 📚 Sistema de Gestión de Biblioteca
Este proyecto es una solución integral para la gestión de una biblioteca, desarrollada en Java. Utiliza una arquitectura robusta basada en el patrón de diseño MVC (Modelo-Vista-Controlador) y un sistema de gestión de errores mediante excepciones personalizadas.

# 🚀 Funcionalidades Actualizadas
Gracias a la reciente expansión del sistema, el programa permite:

Gestión de Usuarios: Registro y visualización completa del censo de socios.

Inventario Dinámico: Registro de libros con control de copias físicas.

Sistema de Préstamos Inteligente: * Validación de disponibilidad de copias.

Límite de 3 libros por usuario.

Cálculo de fechas de vencimiento (30 días).

Gestión de Devoluciones: Proceso de retorno de ejemplares para actualizar el stock.

Búsquedas Avanzadas: Localización de ejemplares por Título, ISBN o Género.

# 🏗️ Estructura del Proyecto
El código se organiza en los siguientes paquetes para garantizar la separación de responsabilidades:

biblioteca.model: Contiene las entidades (Libro, Usuario, PrestamoLibro) y estados (EstadoLibro, Genero). Se encarga puramente de los datos.

biblioteca.controller: Representado por GestorBiblioteca, gestiona la lógica de negocio y las validaciones.

biblioteca.view: La clase Consola, que gestiona los menús y la interacción con el usuario.

biblioteca.exceptions: Capa de seguridad que captura errores lógicos como el exceso de préstamos.

biblioteca.app: Clase Main que inicializa los componentes del sistema.

# 🤝 Reparto de Trabajo (División de Tareas)
Para este proyecto, el desarrollo se dividió estratégicamente entre los dos miembros del equipo:

👤 FabiTheo1 (Fabián González Olofsson)
Arquitectura y Estructura: Migración del código inicial al patrón de diseño MVC.

Capa de Excepciones: Creación y diseño de la lógica de excepciones personalizadas (LibroNoDisponibleException, LimitePrestamosExcedidoException).

Corrección de Modelos: Solución de errores críticos de inicialización en la clase Usuario y optimización de la clase Libro.

Configuración de Entorno: Gestión del repositorio remoto en GitHub, organización de la estructura de paquetes y creación de la documentación técnica inicial.

👤 DanielFMdev (Daniel Flores Medina)
Lógica de Negocio Extendida: Implementación del sistema de Devolución de Préstamos y actualización de stock en tiempo real.

Búsquedas Avanzadas: Desarrollo de los algoritmos de búsqueda por ISBN, Género y Título en el controlador.

Mejora de la Interfaz (Consola): Diseño de los menús de visualización ("Listar Usuarios" y "Listar Libros") y el menú de selección de búsqueda.

Refactorización del Controlador: Implementación de métodos para la extracción de listas de datos desde el modelo hacia la vista.

# 🛠️ Tecnologías Utilizadas
Lenguaje: Java 17+

Gestión de Fechas: java.time.LocalDate

Colecciones: ArrayList para la gestión dinámica de datos.

Versionado: Git & GitHub.

# 📥 Ejecución
Para ejecutar el proyecto, simplemente clona el repositorio y lanza la clase Main.java:
git clone https://github.com/DanielFMdev/GestionBiblioteca.git
