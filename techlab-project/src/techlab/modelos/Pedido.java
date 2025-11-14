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

//Metodos
    public double sumarTotal(ArrayList<Producto> inventario){
        pedido.forEach((String p, Integer i) -> {
            for(Producto producto : inventario){
                if(producto.getNombre().equals(p)){
                    totalCompra += Math.floor(producto.getPrecio() * i);
                }
            }
        });

        return totalCompra;
    }

    //TODO: Obtener el stock del producto para limitar la cantidad e imprimir un msj en consola si no se cumple
    public void agregarProducto(ArrayList<Producto> array, String producto, int cantidad){
        boolean productoExiste = false;
        boolean stockSuficiente = false;

        for(Producto prod : array){
            if(prod.getNombre().equals(producto) && prod.getStock() >= cantidad){
                productoExiste = true;
                stockSuficiente = true;
            } else {
                System.out.println("El producto seleccionado es inexistente o no hay stock suficiente.\n" +
                        "Por favor verifique los datos ingresados." + prod.getNombre() + "stock: " + prod.getStock());
            }
        }
        if(cantidad > 0 && productoExiste && stockSuficiente){
            pedido.put(producto, cantidad);
        }
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
