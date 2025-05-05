package security.wolfgym.SecurityApiWolfGym.data;

import security.wolfgym.SecurityApiWolfGym.domain.Empleado;
import security.wolfgym.SecurityApiWolfGym.domain.Rol;
import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public Usuario validarLogin(String nombreUsuario, String contrasena) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("dbo")
                .withProcedureName("sp_ValidarLogin")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("@usuario", Types.NVARCHAR),
                        new SqlParameter("@contrasena", Types.NVARCHAR)
                )
                .returningResultSet("usuario",
                        (rs, rowNum) -> {
                            Usuario usuario = new Usuario();
                            usuario.setUsuarioId(rs.getInt("usuario_id"));
                            usuario.setUsuario(rs.getString("usuario"));
                            usuario.setContrasena(rs.getString("contrasena"));

                            Empleado empleado = new Empleado();
                            empleado.setIdEmpleado(rs.getInt("id_empleado"));
                            empleado.setNombreEmpleado(rs.getString("nombre_empleado"));
                            empleado.setApellidosEmpleado(rs.getString("apellidos_empleado"));
                            usuario.setEmpleado(empleado);

                            Rol rol = new Rol();
                            rol.setIdRol(rs.getInt("rol_id"));
                            rol.setNombreRol(rs.getString("nombre_rol"));
                            usuario.setRol(rol);

                            return usuario;
                        });

        Map<String, Object> result = simpleJdbcCall.execute(
                Map.of(
                        "@usuario", nombreUsuario,
                        "@contrasena", contrasena
                )
        );

        List<Usuario> usuarios = (List<Usuario>) result.get("usuario");

        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        }

        return usuarios.get(0);
    }
}
