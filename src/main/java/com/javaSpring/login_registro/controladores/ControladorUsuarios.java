package com.javaSpring.login_registro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.login_registro.modelos.LoginUsuario;
import com.javaSpring.login_registro.modelos.Usuario;
import com.javaSpring.login_registro.servicios.ServicioUsuarios;

import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    // Form de login y registro
    @GetMapping("/") 
    public String forms(Model modelo) {
        modelo.addAttribute("loginUsuario", new LoginUsuario());
        modelo.addAttribute("usuario", new Usuario());
        return "index.jsp";
    }

    // Procesando login
    @PostMapping("/procesa/login") 
    public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
            BindingResult validaciones, Model modelo) {
        validaciones = this.servicioUsuarios.validarNombreUsuarioYPassword(validaciones, loginUsuario);
        if (validaciones.hasErrors()) {
            modelo.addAttribute("usuario", new Usuario());
            return "index.jsp";
        }
        return "redirect:/inicio";
    }

    // Procesando registro
    @PostMapping("/procesa/registro") 
    public String register(@Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult validaciones, Model modelo) {
        validaciones = this.servicioUsuarios.validarPasswords(validaciones, usuario);
        if (validaciones.hasErrors()) {
            modelo.addAttribute("loginUsuario", new LoginUsuario());
            return "index.jsp";
        }
        servicioUsuarios.crearUsuario(usuario);
        return "redirect:/inicio";
    }

    // inicio
    @GetMapping("/inicio")
    public String inicio() {
    return "inicio.jsp";
    }

}
