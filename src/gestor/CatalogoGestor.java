package src.gestor;

import src.producto.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar un catálogo de productos, permitiendo agregar, eliminar,
 * modificar y listar productos, además de guardarlos y cargarlos desde un archivo CSV.
 */
public class CatalogoGestor {
    private List<Producto> productos;
    private final String archivoCSV = "productos.csv";

    /**
     * Constructor de CatalogoGestor. Inicializa la lista de productos y carga los productos
     * desde el archivo CSV.
     */
    public CatalogoGestor() {
        this.productos = new ArrayList<>();
        cargarProductos();
    }

    /**
     * Carga los productos desde el archivo CSV en la lista de productos.
     */
    public void cargarProductos() {
        productos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) { 
                    String nombre = datos[0];
                    double precio = Double.parseDouble(datos[1]);
                    int cantidad = Integer.parseInt(datos[2]);
                    productos.add(new Producto(nombre, precio, cantidad));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de productos: " + e.getMessage());
        }
    }

    /**
     * Guarda todos los productos en el archivo CSV.
     */
    public void guardarProductos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV))) {
            for (Producto producto : productos) {
                writer.println(producto.toString());
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de productos: " + e.getMessage());
        }
    }

    /**
     * Agrega un producto al catálogo y lo guarda en el archivo CSV.
     *
     * @param producto el producto a agregar
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductos();
        System.out.println("Producto agregado y guardado en el archivo CSV.");
    }

    /**
     * Elimina un producto del catálogo según su nombre y actualiza el archivo CSV.
     *
     * @param nombre el nombre del producto a eliminar
     */
    public void eliminarProducto(String nombre) {
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombre));
        guardarProductos();
        System.out.println("Producto eliminado y archivo CSV actualizado.");
    }

    /**
     * Modifica el precio y la cantidad de un producto existente en el catálogo y actualiza el archivo CSV.
     *
     * @param nombre       el nombre del producto a modificar
     * @param nuevoPrecio  el nuevo precio del producto
     * @param nuevaCantidad la nueva cantidad del producto
     */
    public void modificarProducto(String nombre, double nuevoPrecio, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setPrecio(nuevoPrecio);
                producto.setCantidad(nuevaCantidad);
                guardarProductos();
                System.out.println("Producto modificado y archivo CSV actualizado.");
                break;
            }
        }
    }

    /**
     * Muestra todos los productos en el catálogo.
     */
    public void mostrarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Cantidad: " + producto.getCantidad());
        }
    }
}

