package security.wolfgym.SecurityApiWolfGym.mapper;

import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import security.wolfgym.SecurityApiWolfGym.dto.LoginDTO;

public class LoginMapper {

    public static Usuario toUsuario(LoginDTO loginDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(loginDTO.getUsuario());
        usuario.setContrasena(loginDTO.getContrasena());
        return usuario;
    }
}
