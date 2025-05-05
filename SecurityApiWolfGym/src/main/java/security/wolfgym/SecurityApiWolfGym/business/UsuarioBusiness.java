package security.wolfgym.SecurityApiWolfGym.business;

import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import security.wolfgym.SecurityApiWolfGym.data.UsuarioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBusiness {

    @Autowired
    private UsuarioData usuarioData;

    /**
     * Valida las credenciales del usuario utilizando el procedimiento almacenado sp_ValidarLogin.
     *
     * @param usuario    Nombre de usuario ingresado
     * @param contrasena Contraseña ingresada
     * @return Usuario completo si las credenciales son válidas
     * @throws IllegalArgumentException si algún parámetro es inválido o las credenciales no coinciden
     */
    
    
    public Usuario validarLogin(String usuario, String contrasena) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El parámetro 'usuario' no puede estar vacío ni ser nulo.");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("El parámetro 'contrasena' no puede estar vacío ni ser nulo.");
        }

        Usuario u = usuarioData.validarLogin(usuario.trim(), contrasena.trim());

        if (u == null) {
            throw new IllegalArgumentException("Credenciales inválidas: usuario o contraseña incorrectos.");
        }

        return u;
    }
}
