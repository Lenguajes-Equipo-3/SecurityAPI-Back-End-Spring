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
                );

        // Ejecutar el SP
        Map<String, Object> result = simpleJdbcCall.execute(
                Map.of("@usuario", nombreUsuario, "@contrasena", contrasena)
        );

        // El nombre por defecto del result set es "#result-set-1"
        List<Map<String, Object>> rows = (List<Map<String, Object>>) result.get("#result-set-1");

        if (rows == null || rows.isEmpty()) {
            return null;
        }

        // Usamos la primera fila para construir el Usuario y Empleado
        Map<String, Object> firstRow = rows.get(0);

        Usuario usuario = new Usuario();
        usuario.setUsuarioId((Integer) firstRow.get("usuario_id"));
        usuario.setUsuario((String) firstRow.get("usuario"));
        usuario.setContrasena((String) firstRow.get("contrasena"));

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado((Integer) firstRow.get("id_empleado"));
        empleado.setNombreEmpleado((String) firstRow.get("nombre_empleado"));
        empleado.setApellidosEmpleado((String) firstRow.get("apellidos_empleado"));
        usuario.setEmpleado(empleado);

        // Crear la lista de roles a partir de todas las filas
        List<Rol> roles = new java.util.ArrayList<>();
        for (Map<String, Object> row : rows) {
            Rol rol = new Rol();
            rol.setIdRol((Integer) row.get("rol_id"));
            rol.setNombreRol((String) row.get("nombre_rol"));
            roles.add(rol);
        }
        usuario.setRoles(roles);

        return usuario;
    }

    
}
