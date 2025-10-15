package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public List<Usuario> filtrarUsuariosValidos(List<Usuario> usuarios) {
        List<Usuario> validos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getIdade() >= 0) {
                validos.add(usuario);
            } else {
                System.out.println("Usuário inválido ignorado: " + usuario);
            }
        }

        return validos;
    }
}
