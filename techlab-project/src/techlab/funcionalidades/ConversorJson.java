package techlab.funcionalidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techlab.modelos.Cliente;
import techlab.modelos.Pedido;
import techlab.modelos.Producto;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConversorJson {

    public ArrayList<Producto> obtenerInventario() {
        File fileInventario = new File("src/techlab/data/inventario.json");
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        ArrayList<Producto> inventario = new ArrayList<>();
        if (fileInventario.exists()) {
            try (Reader reader = new FileReader(fileInventario)) {
                Type listType = new TypeToken<ArrayList<Producto>>() {
                }.getType();
                inventario = gson.fromJson(reader, listType);
                if (inventario == null) inventario = new ArrayList<>();
                System.out.println("📥 Productos cargados desde " + fileInventario);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            inventario = new ArrayList<>();
            System.out.println("No existe el archivo JSON, lista vacía creada.");
        }

        return inventario;
    }

    public ArrayList<Pedido> obtenerPedidos() {
        File filePedidos = new File("src/techlab/data/pedidos.json");
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        if (filePedidos.exists()) {
            try (Reader reader = new FileReader("src/techlab/data/pedidos.json")) {
                Type listType = new TypeToken<ArrayList<Pedido>>() {
                }.getType();
                pedidos = gson.fromJson(reader, listType);
                if (pedidos == null) pedidos = new ArrayList<>();
                System.out.println("📥 Productos cargados desde " + filePedidos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            pedidos = new ArrayList<>();
            System.out.println("No existe el archivo JSON, lista vacía creada.");
        }
        return pedidos;
    }

    public ArrayList<Cliente> obtenerClientes() {
        File fileClientes = new File("src/techlab/data/clientes.json");
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (fileClientes.exists()) {
            try (Reader reader = new FileReader(fileClientes)) {
                Type listType = new TypeToken<ArrayList<Cliente>>() {
                }.getType();
                clientes = gson.fromJson(reader, listType);
                if (clientes == null) clientes = new ArrayList<>();
                System.out.println("📥 Productos cargados desde " + fileClientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            clientes = new ArrayList<>();
            System.out.println("No existe el archivo JSON, lista vacía creada.");
        }
        return clientes;
    }


    public void sobreescribirJson(ArrayList array, String file){
        try {
            Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(gson.toJson(array));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
