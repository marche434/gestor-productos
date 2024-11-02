package src.producto;

/**
 * Clase que representa un producto con un nombre, precio y cantidad.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    /**
     * Constructor de Producto.
     *
     * @param nombre   el nombre del producto
     * @param precio   el precio del producto
     * @param cantidad la cantidad disponible del producto
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre el nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio el nuevo precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad del producto.
     *
     * @return la cantidad del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     *
     * @param cantidad la nueva cantidad del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retorna una representación en cadena del producto en formato CSV.
     *
     * @return una cadena con el nombre, precio y cantidad del producto
     */
    @Override
    public String toString() {
        return nombre + "," + precio + "," + cantidad;
    }
}

