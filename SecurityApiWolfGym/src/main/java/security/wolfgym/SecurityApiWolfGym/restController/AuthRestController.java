package security.wolfgym.SecurityApiWolfGym.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.wolfgym.SecurityApiWolfGym.business.UsuarioBusiness;
import security.wolfgym.SecurityApiWolfGym.domain.Usuario;
import security.wolfgym.SecurityApiWolfGym.dto.LoginDTO;
import security.wolfgym.SecurityApiWolfGym.dto.UsuarioLoginResponseDTO;
import security.wolfgym.SecurityApiWolfGym.mapper.UsuarioMapper;
import security.wolfgym.SecurityApiWolfGym.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            // 1. Validar usuario
            Usuario usuario = usuarioBusiness.validarLogin(
                    loginDTO.getUsuario(), loginDTO.getContrasena());

            if (usuario == null) {
                return ResponseEntity.status(401).body("❌ Usuario o contraseña incorrectos.");
            }

            // 2. Obtener los nombres de roles
            List<String> nombresRoles = usuario.getRoles().stream()
                    .map(rol -> rol.getNombreRol())
                    .toList();

            // 3. Generar token con los roles unidos (por ejemplo, separados por coma)
            String rolesConcatenados = String.join(",", nombresRoles);
            String token = jwtUtil.generateToken(usuario.getUsuario(), rolesConcatenados);

            // 4. Mapear a DTO de respuesta
            UsuarioLoginResponseDTO responseDTO = UsuarioMapper.toLoginResponse(usuario, token);
 System.out.print(responseDTO.getIdEmpleado());
            // 5. Respuesta exitosa
            return ResponseEntity.ok(responseDTO);
            
            

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("❌ " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("⚠️ Error interno al procesar el login. " + e.getMessage());
        }
    }
}

