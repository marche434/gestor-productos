package src.aplicacion;

import src.gestor.CatalogoGestor;
import src.producto.Producto;
import java.util.Scanner;

/**
 * Clase principal para interactuar con el usuario y gestionar el catálogo de productos.
 */
public class Main {
    /**
     * Método principal para la ejecución de la aplicación.
     *
     * @param args los argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        CatalogoGestor gestor = new CatalogoGestor();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestor de Catálogo de Productos");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    gestor.agregarProducto(new Producto(nombre, precio, cantidad));
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestor.eliminarProducto(nombreEliminar);
                    System.out.println("Producto eliminado.");
                    break;
                case 3:
                    System.out.print("Nombre del producto a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    gestor.modificarProducto(nombreModificar, nuevoPrecio, nuevaCantidad);
                    System.out.println("Producto modificado.");
                    break;
                case 4:
                    System.out.println("Productos en el catálogo:");
                    gestor.mostrarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

