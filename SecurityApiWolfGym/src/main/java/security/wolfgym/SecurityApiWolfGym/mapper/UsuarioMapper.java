package security.wolfgym.SecurityApiWolfGym.mapper;

import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import security.wolfgym.SecurityApiWolfGym.dto.UsuarioLoginResponseDTO;

public class UsuarioMapper {

    public static UsuarioLoginResponseDTO toLoginResponse(Usuario usuario, String token) {
        return new UsuarioLoginResponseDTO(
            usuario.getUsuario(),
            usuario.getEmpleado().getNombreEmpleado(),
            usuario.getEmpleado().getApellidosEmpleado(),
            usuario.getRol().getNombreRol(),
            token
        );
    }
}
