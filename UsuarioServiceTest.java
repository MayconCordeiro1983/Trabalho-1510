package service;

import model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class UsuarioServiceTest {

    @Test
    void testUsuariosValidos() {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("João", 30, "São Paulo"));
        lista.add(new Usuario("Carlos", -5, "Brasília"));

        UsuarioService service = new UsuarioService();
        List<Usuario> validos = service.filtrarUsuariosValidos(lista);

        assertEquals(1, validos.size());
        assertEquals("João", validos.get(0).getNome());
    }
}
