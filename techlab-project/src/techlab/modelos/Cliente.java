package techlab.modelos;

public class Cliente {
    private String nombre;
    private String email;
    private int comprasRealizadas = 0;

    public Cliente(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas =+ comprasRealizadas;
    }



}
