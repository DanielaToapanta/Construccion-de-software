import java.io.*;
import java.util.*;

public class QuijoteTokenizer {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("Quijote.txt"));
        String linea;
        while ((linea = br.readLine()) != null) {
            sb.append(linea).append(" ");
        }
        br.close();

        String texto = sb.toString().toLowerCase();
        texto = texto.replaceAll("[,;.:¿?¡!\"'()—]", "");

        StringTokenizer st = new StringTokenizer(texto);
        Map<String, Integer> conteo = new HashMap<>();

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            conteo.put(palabra, conteo.getOrDefault(palabra, 0) + 1);
        }

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(conteo.entrySet());
        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("=== LAS 8 PALABRAS MÁS FRECUENTES EN EL DISCURSO SON ===");
        for (int i = 0; i < 8; i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getKey() 
                               + " " + lista.get(i).getValue() + " ocurrencias");
        }
    }
}