package integration;

import model.Usuario;
import service.UsuarioService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UsuarioIntegrationTest {

    public static void main(String[] args) {
        List<Usuario> usuarios = lerUsuariosDoCSV("usuarios.csv");

        System.out.println("Total lido do CSV: " + usuarios.size());

        UsuarioService service = new UsuarioService();
        List<Usuario> validos = service.filtrarUsuariosValidos(usuarios);

        System.out.println("Total de usuários válidos: " + validos.size());

        // Teste simples
        if (validos.size() == 2) {
            System.out.println("✅ Teste OK: usuários válidos corretamente filtrados.");
        } else {
            System.out.println("❌ Teste FALHOU!");
        }

        // Exibir os válidos
        for (Usuario u : validos) {
            System.out.println("✅ " + u);
        }
    }

    private static List<Usuario> lerUsuariosDoCSV(String caminho) {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean primeira = true;

            while ((linha = br.readLine()) != null) {
                if (primeira) { primeira = false; continue; }

                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String nome = partes[0].trim();
                    int idade = Integer.parseInt(partes[1].trim());
                    String cidade = partes[2].trim();

                    usuarios.add(new Usuario(nome, idade, cidade));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler CSV: " + e.getMessage());
        }

        return usuarios;
    }
}
