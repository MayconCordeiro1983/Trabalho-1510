package main;

import model.Usuario;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar lista de usuários (alguns válidos, outros inválidos)
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João", 30, "São Paulo"));
        usuarios.add(new Usuario("Maria", 25, "Rio de Janeiro"));
        usuarios.add(new Usuario("Carlos", -5, "Brasília")); // inválido

        // Usar o serviço para filtrar usuários válidos
        UsuarioService service = new UsuarioService();
        List<Usuario> usuariosValidos = service.filtrarUsuariosValidos(usuarios);

        // Exibir resultados
        System.out.println("\nUsuários válidos:");
        for (Usuario u : usuariosValidos) {
            System.out.println(u);
        }
    }
}
