package security.wolfgym.SecurityApiWolfGym.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import security.wolfgym.SecurityApiWolfGym.data.UsuarioData;
import security.wolfgym.SecurityApiWolfGym.domain.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioBusinessTest {

    @Mock
    private UsuarioData usuarioData;

    @InjectMocks
    private UsuarioBusiness usuarioBusiness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidarLogin_Exitoso() {
        // Arrange
        Usuario mockUsuario = new Usuario();
        mockUsuario.setUsuario("JorgeAdmin");

        when(usuarioData.validarLogin("JorgeAdmin", "admin")).thenReturn(mockUsuario);

        // Act
        Usuario result = usuarioBusiness.validarLogin("JorgeAdmin", "admin");

        // Assert
        assertNotNull(result);
        assertEquals("JorgeAdmin", result.getUsuario());
        verify(usuarioData, times(1)).validarLogin("JorgeAdmin", "admin");
    }

    @Test
    void testValidarLogin_UsuarioNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioBusiness.validarLogin(null, "1234"));

        assertEquals("El parámetro 'usuario' no puede estar vacío ni ser nulo.", exception.getMessage());
        verify(usuarioData, never()).validarLogin(any(), any());
    }

    @Test
    void testValidarLogin_UsuarioVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioBusiness.validarLogin("   ", "1234"));

        assertEquals("El parámetro 'usuario' no puede estar vacío ni ser nulo.", exception.getMessage());
        verify(usuarioData, never()).validarLogin(any(), any());
    }

    @Test
    void testValidarLogin_ContrasenaNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioBusiness.validarLogin("admin", null));

        assertEquals("El parámetro 'contrasena' no puede estar vacío ni ser nulo.", exception.getMessage());
        verify(usuarioData, never()).validarLogin(any(), any());
    }

    @Test
    void testValidarLogin_ContrasenaVacia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioBusiness.validarLogin("admin", " "));

        assertEquals("El parámetro 'contrasena' no puede estar vacío ni ser nulo.", exception.getMessage());
        verify(usuarioData, never()).validarLogin(any(), any());
    }

    @Test
    void testValidarLogin_CredencialesInvalidas() {
        when(usuarioData.validarLogin("admin", "wrongpass")).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioBusiness.validarLogin("admin", "wrongpass"));

        assertEquals("Credenciales inválidas: usuario o contraseña incorrectos.", exception.getMessage());
        verify(usuarioData, times(1)).validarLogin("admin", "wrongpass");
    }
}
