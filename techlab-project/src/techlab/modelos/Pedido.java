package techlab.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido{

    private Map<String, Integer> pedido = new HashMap<>();
    private int idCompra;
    private double totalCompra;


//Getters and setters
public Map<String, Integer> getPedido() {
    return pedido;
}

    public void setPedido(Map<String, Integer> pedido) {
        this.pedido = pedido;
    }

    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }


//Metodos
    public double sumarTotal(ArrayList<Producto> inventario){
        pedido.forEach((String p, Integer i) -> {
           double total = inventario.get(inventario.indexOf(inventario.equals(p))).getPrecio() * i;
           totalCompra += total;
        });

        return totalCompra;

    }

    public void agregarProducto(String producto, int cantidad){
        pedido.put(producto, cantidad);
    }

    public void mostrarPedido(){
        System.out.println("---------------------------\n" +
                "Pedido Nro: " + idCompra + "\n");
        pedido.forEach((String p, Integer i) -> {
            System.out.println(p + " : " + i);
        });
        System.out.println();

        System.out.println("Total: " + totalCompra + "\n " +
                "---------------------------");

    }
}
