package techlab.modelos;

import techlab.Descuentos;

import java.util.ArrayList;

public class Pedido{
    private ArrayList<Producto> pedido = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();
    private int idCompra;
    private double totalCompra;


//Getters and setters
    public ArrayList<Producto> getPedido() {
        return pedido;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

//Metodos
    public double sumarTotal(){
        double total = 0;
        for(Producto p : pedido){
            total += p.getPrecio() * cantidades.get(pedido.indexOf(p));
        }
        return total;
    }

    public void agregarProducto(Producto producto, int cantidad){
        this.pedido.add(producto);
        this.cantidades.add(cantidad);
    }

    public void mostrarPedido(){
        System.out.println("---------------------------");
        for(Producto p : pedido){
            System.out.println(p.getNombre() + " : " + cantidades.get(pedido.indexOf(p)));
        }
        System.out.println("Total: " + sumarTotal());
        System.out.println("---------------------------");

    }
}
