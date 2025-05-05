package security.wolfgym.SecurityApiWolfGym.restController;

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
            // 1. Validar usuario con la lógica de negocio
            Usuario usuario = usuarioBusiness.validarLogin(
                    loginDTO.getUsuario(), loginDTO.getContrasena());

            // 2. Generar token JWT
            String token = jwtUtil.generateToken(
                    usuario.getUsuario(), usuario.getRol().getNombreRol());

            // 3. Mapear a DTO de respuesta
            UsuarioLoginResponseDTO responseDTO = UsuarioMapper.toLoginResponse(usuario, token);

            // 4. Devolver respuesta exitosa con token y datos
            return ResponseEntity.ok(responseDTO);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("❌ " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("⚠️ Error interno al procesar el login."+ e.getMessage());
        }
    }
}
