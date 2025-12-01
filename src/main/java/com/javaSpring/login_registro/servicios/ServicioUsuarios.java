package com.javaSpring.login_registro.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaSpring.login_registro.modelos.LoginUsuario;
import com.javaSpring.login_registro.modelos.Usuario;
import com.javaSpring.login_registro.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public Usuario crearUsuario(Usuario usuario) {
        String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(hashPassword);
        return this.repositorioUsuarios.save(usuario);
    }

    public Usuario obtenerPorId(Long id) {
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
        return this.repositorioUsuarios.findByNombreUsuario(nombreUsuario).orElse(null);
    }

    // Validación de coincidencia en passwords
    public BindingResult validarPasswords(BindingResult validaciones, Usuario usuario) {
        if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
            validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contraseñas no coinciden.");
        }
        return validaciones;
    }

   // Validación de nombreUsuario y password
    public BindingResult validarNombreUsuarioYPassword(BindingResult validaciones, LoginUsuario loginUsuario) {
        Usuario usuarioDB = this.obtenerPorNombreUsuario(loginUsuario.getNombreUsuario());
        if (usuarioDB == null) {
            validaciones.rejectValue("nombreUsuario", "nombreUsuarioNoRegistrado",
                    "El nombre de usuario ingresado no corresponde a ningún usuario registrado.");
        } else {
            if (!BCrypt.checkpw(loginUsuario.getPassword(), usuarioDB.getPassword())) {
                validaciones.rejectValue("password", "passwordIncorrecta", "Credenciales incorrectas.");
            }
        }
        return validaciones;
    }
}
