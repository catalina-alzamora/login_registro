package com.javaSpring.login_registro.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

    @NotBlank(message = "Por favor proporciona un nombre de usuario.")
    @Size(min = 3, max = 15, message = "Debe contener al menos 3 caracteres y un máximo de 15.")
    private String nombreUsuario;

    @NotBlank(message = "Por favor proporciona un contraseña.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    private String password;

    public LoginUsuario() {
    }

    public LoginUsuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
