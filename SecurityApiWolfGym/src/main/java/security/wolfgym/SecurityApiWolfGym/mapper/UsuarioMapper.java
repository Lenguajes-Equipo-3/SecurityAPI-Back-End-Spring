package security.wolfgym.SecurityApiWolfGym.mapper;

import security.wolfgym.SecurityApiWolfGym.domain.Rol;
import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import security.wolfgym.SecurityApiWolfGym.dto.UsuarioLoginResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioLoginResponseDTO toLoginResponse(Usuario usuario, String token) {
        List<String> nombresRoles = usuario.getRoles().stream()
                .map(Rol::getNombreRol)
                .collect(Collectors.toList());

        return new UsuarioLoginResponseDTO(
                usuario.getUsuario(),
                usuario.getEmpleado().getNombreEmpleado(),
                usuario.getEmpleado().getApellidosEmpleado(),
                usuario.getEmpleado().getIdEmpleado(),
                nombresRoles,
                token
        );
    }
}
