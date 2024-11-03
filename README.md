# Gestor de Catálogo de Productos

Este proyecto es una aplicación de consola en Java que permite gestionar un catálogo de productos. Los usuarios pueden agregar, eliminar, modificar y listar productos. Además, los datos de los productos se guardan en un archivo CSV para asegurar persistencia.

## Estructura del Proyecto

La estructura del proyecto es la siguiente:



![Diagrama de Clases](./class_diagram.png)




## Descripción de las Clases

- **Producto**: Clase que representa un producto con atributos como nombre, precio y cantidad.
- **CatalogoGestor**: Clase que gestiona el catálogo de productos, proporcionando métodos para agregar, eliminar, modificar y mostrar productos, así como para guardar y cargar productos desde un archivo CSV.
- **Main**: Clase principal que permite al usuario interactuar con el catálogo a través de un menú de opciones en la consola.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- `make` para utilizar el Makefile.

## Comandos del Makefile

Este proyecto incluye un `Makefile` para facilitar las siguientes tareas:

- **Compilar el proyecto**: 

    ```bash
    make compile
    ```

- **Generar el archivo JAR**:

    ```bash
    make jar
    ```

- **Ejecutar el programa desde el JAR**:

    ```bash
    make run
    ```

- **Generar la documentación Javadoc**:

    ```bash
    make javadoc
    ```

- **Limpiar archivos generados (clases compiladas, JAR y MANIFEST)**:

    ```bash
    make clean
    ```

- **Limpiar todos los archivos generados, incluyendo la documentación Javadoc**:

    ```bash
    make clean_all
    ```

- **Ver ayuda sobre los comandos disponibles en el Makefile**:

    ```bash
    make help
    ```

## Uso

1. **Compilación y Ejecución**

   Puedes compilar el proyecto y ejecutar el programa usando el siguiente comando:

    ```bash
    make run
    ```

   Esto compilará el código, creará el archivo JAR y ejecutará el programa.

2. **Generación de Documentación**

   Para generar la documentación Javadoc de las clases:

    ```bash
    make javadoc
    ```

   La documentación generada se encontrará en el directorio `docs`, y puedes abrir el archivo `docs/index.html` en un navegador para visualizarla.

## Ejemplo de Uso

Al ejecutar el programa, verás un menú con opciones para:

1. Agregar producto
2. Eliminar producto
3. Modificar producto
4. Mostrar productos
5. Salir

Selecciona una opción y sigue las instrucciones en pantalla. La aplicación guardará automáticamente cualquier cambio realizado en `productos.csv`.

## Autor

Desarrollado como ejemplo para la asignatura de Programación I.
