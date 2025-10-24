package techlab;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techlab.modelos.Cliente;
import techlab.modelos.Pedido;
import techlab.modelos.Producto;
import techlab.funcionalidades.FuncionesMenu;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean menuActivo = true;
        Gson gson = new Gson();
        FuncionesMenu menu = new FuncionesMenu();

            File file = new File("inventario.json");
            ArrayList<Producto> inventario = new ArrayList<>();
            if (file.exists()) {
                try (Reader reader = new FileReader("inventario.json")) {
                    Type listType = new TypeToken<ArrayList<Producto>>() {
                    }.getType();
                    inventario = gson.fromJson(reader, listType);
                    if (inventario == null) inventario = new ArrayList<>();
                    System.out.println("📥 Productos cargados desde " + file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                inventario = new ArrayList<>();
                System.out.println("No existe el archivo JSON, lista vacía creada.");
            }


        ArrayList<Pedido> pedidos = new ArrayList<>();

        System.out.println("=================================== SISTEMA DE GESTIÓN - TECHLAB ==================================");
        System.out.println("Bienvenido/a por favor ingrese su nombre:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ahora por favor ingrese su correo electrónico: ");
        String emailCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente, emailCliente);

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

            //TODO reducir todo el código métodos
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
                    menu.cerrarMenu(menuActivo);
                    FileWriter fileWriter = new FileWriter("inventario.json");
                    fileWriter.write(gson.toJson(inventario));
                    fileWriter.close();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while(menuActivo);

        //Agregar el archivo a inventario.json



    }


}
