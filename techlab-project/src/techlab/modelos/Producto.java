package techlab.modelos;

import techlab.funcionalidades.FormatearTexto;

public class Producto {
    private String nombre;
    private int id;
    private double precio;
    private int stock;

    public Producto(String nombre, int id, double precio, int stock){
        FormatearTexto formatear = new FormatearTexto();
        this.nombre = formatear.formatear(nombre);
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock >= 0){
            this.stock = stock;
        }
    }


    public void mostrarInformacion() {
        System.out.println("Nombre:" + this.nombre);
        System.out.println("ID:" + this.id);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Stock disponible: " + this.stock);
    }
}
