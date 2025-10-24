package techlab.funcionalidades;

import techlab.modelos.Pedido;
import techlab.modelos.Producto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesMenu {

    //Agregar un producto al inventario
    public void agregarProductoAlInventario(ArrayList array, Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese el precio: ");
        double precioProducto = scanner.nextDouble();
        int productoId;
        try {
            productoId = array.size() + 1;
        } catch (NullPointerException e){
            productoId = 1;
        }
        System.out.println("Se creo id para el producto: " + nombreProducto + " " + productoId);
        System.out.println("Ingrese el stock actual del producto: ");
        int productoStock = scanner.nextInt();
        Producto producto = new Producto(nombreProducto, productoId, precioProducto, productoStock);
        array.add(producto);
        producto.mostrarInformacion();
    }

    //Listar los productos
    public void listarProductos(ArrayList<Producto> array){
        System.out.println("Inventario: ");
        for (Producto prod : array) {
            prod.mostrarInformacion();
            System.out.println("----------------------");
        }
    }

    //Modificar el atributo de un producto
    public void modificarAtributoProducto(ArrayList<Producto> array, Scanner scanner){
        System.out.println("Por favor ingrese el nombre del producto que quiere buscar/modificar: ");
        scanner.nextLine();
        String productoBuscar = scanner.nextLine();
        for (Producto p : array) {
            if (p.getNombre().equals(productoBuscar)) {
                p.mostrarInformacion();
                System.out.println("Ingrese el valor que quiere modificar:\n" +
                        "1-Modificar nombre\n" +
                        "2-Modificar precio\n" +
                        "3-Modificar stock");
                scanner.nextLine();
                int opcionCambiar = scanner.nextInt();
                switch (opcionCambiar) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        scanner.nextLine();
                        String nuevoNombre = scanner.nextLine();
                        p.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado.");
                        p.mostrarInformacion();
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo precio: ");
                        scanner.nextLine();
                        double nuevoPrecio = scanner.nextDouble();
                        p.setPrecio(nuevoPrecio);
                        System.out.println("Precio actualizado.");
                        p.mostrarInformacion();
                        break;

                    case 3:
                        System.out.println("Ingrese el stock del producto: ");
                        scanner.nextLine();
                        int nuevoStock = scanner.nextInt();
                        p.setStock(scanner.nextInt());
                        System.out.println("Stock actualizado.");
                        p.mostrarInformacion();
                        break;
                    default:
                        System.out.println("Opcion no válida.");
                        break;
                }
                p.mostrarInformacion();
            }
        }
    }

    //Eliminar un producto del inventario
    public void eliminarProducto(ArrayList<Producto> array, Scanner scanner){
        scanner.nextLine();
        System.out.println("Por favor ingrese el producto que quiere eliminar: ");
        String prodEliminar = scanner.nextLine();
        for (Producto p : array) {
            if (p.getNombre().equals(prodEliminar)) {
                System.out.println("Este es el producto que desea eliminar del inventario?"
                );
                p.mostrarInformacion();
                String opBorrar = scanner.nextLine();
                switch (opBorrar) {
                    case "Si":
                        System.out.println("Producto eliminado.");
                        array.remove(p);
                        break;
                    case "No":
                        System.out.println("Producto no encontrado.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }
        System.out.println(prodEliminar + " ha sido eliminado del inventario.");
    }

    //Crear un pedido
    public void crearPedido(ArrayList<Producto> array, ArrayList<Pedido> pedidos, Scanner scanner){
        boolean pedidoEnProceso = true;
        int idpedido = 0;
        idpedido++;
        Pedido pedido = new Pedido();
        pedido.setIdCompra(idpedido++);
        while (pedidoEnProceso) {
            for (int i = 0; i <= array.size() - 1; i++) {
                System.out.println(array.get(i).getNombre() + " id: " + array.get(i).getId());
            }
            System.out.println("Por favor ingrese el Id del producto que quiera agregar al pedido: \n");
            System.out.println("Si desea terminar ingrese 0.");
            int idSeleccionado = scanner.nextInt();
            if (idSeleccionado != 0) {
                System.out.println("Ingrese la cantidad que desea comprar: ");
                int cantidad = scanner.nextInt();
                pedido.agregarProducto(array.get(idSeleccionado - 1), cantidad);
            } else {
                pedidoEnProceso = false;
                System.out.println("Pedido terminado : ");
                pedidos.add(pedido);
                pedido.mostrarPedido();
                break;
            }
        }
    }

    //Mostrar lista de pedidos
    public void mostrarPedidos(ArrayList<Pedido> pedidos){
        for(Pedido p : pedidos){
            p.mostrarPedido();
        }
    }

    //Cerrar menú
    public void cerrarMenu(boolean menuActivo){
        System.out.println("Gracias por operar con TECHLAB.");
        menuActivo = false;
    }

}
