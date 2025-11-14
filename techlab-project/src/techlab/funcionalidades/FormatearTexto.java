package techlab.funcionalidades;

public class FormatearTexto {

    public String formatear(String string) {
        string = string.trim().toLowerCase();
        String[] palabras = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
            }
        }
        string = sb.toString().trim();

        return string;
    }
}
