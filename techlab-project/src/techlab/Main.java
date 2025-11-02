package techlab;
import techlab.modelos.Cliente;
import techlab.modelos.Pedido;
import techlab.modelos.Producto;
import techlab.funcionalidades.FuncionesMenu;
import techlab.funcionalidades.ConversorJson;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean menuActivo = true;
        FuncionesMenu menu = new FuncionesMenu();
        ConversorJson conversor = new ConversorJson();
        ArrayList<Pedido> pedidos = conversor.obtenerPedidos();
        ArrayList<Producto> inventario = conversor.obtenerInventario();
        ArrayList<Cliente> clientes = conversor.obtenerClientes();

        System.out.println("=================================== SISTEMA DE GESTIÓN - TECHLAB ==================================");
        System.out.println("Bienvenido/a por favor ingrese su nombre:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ahora por favor ingrese su correo electrónico: ");
        String emailCliente = scanner.nextLine();
        clientes.add(new Cliente(nombreCliente, emailCliente));

        do {
            System.out.println("Elige una opción\n" +
                    "1) Agregar producto\n" +
                    "2) Listar productos\n" +
                    "3) Buscar/Actualizar producto\n" +
                    "4) Eliminar producto\n" +
                    "5) Crear un pedido\n" +
                    "6) Listar pedidos\n" +
                    "7) Salir\n" +
                    "\n" +
                    "Elija una opción:");

            int opcionUsuario = scanner.nextInt();

            switch (opcionUsuario) {
                //Agregar producto al inventario
                case 1:
                    menu.agregarProductoAlInventario(inventario, scanner);
                    break;
                case 2:
                    //Mostrar todos los productos en el inventario.
                    menu.listarProductos(inventario);
                    break;
                case 3:
                    //Modificar el valor de un producto
                    menu.modificarAtributoProducto(inventario, scanner);
                    break;
                //Eliminar un producto
                case 4:
                    menu.eliminarProducto(inventario, scanner);
                    break;
                //Crear un pedido
                case 5:
                    menu.crearPedido(inventario, pedidos, scanner);
                    break;
                //Listar un pedido
                case 6:
                    menu.mostrarPedidos(pedidos);
                    break;
                //Salir
                case 7:
                    System.out.println("Gracias por operar con TECHLAB.");
                    menuActivo = false;
                    conversor.sobreescribirJson(inventario, "src/techlab/data/inventario.json");
                    conversor.sobreescribirJson(pedidos, "src/techlab/data/pedidos.json");
                    conversor.sobreescribirJson(clientes, "src/techlab/data/clientes.json");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while (menuActivo);
    }
}
