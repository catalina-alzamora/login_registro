package com.javaSpring.login_registro.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Por favor proporciona un nombre de usuario.")
    @Size(min = 3, max = 15, message = "Debe contener al menos 3 caracteres y un máximo de 15.")
    private String nombreUsuario;

    @NotBlank(message = "Por favor proporciona tu nombre.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    @Pattern(regexp = "^([^0-9]*)$", message = "El nombre no puede contener números")
    private String nombre;

    @NotBlank(message = "Por favor proporciona tu apellido.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    @Pattern(regexp = "^([^0-9]*)$", message = "El apellido no puede contener números")
    private String apellido;

    @NotBlank(message = "Por favor proporciona tu correo.")
    @Email(message = "Por favor ingresa un correo válido.")
    private String correo;

    @NotBlank(message = "Por favor proporciona un contraseña.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "El password necesita incluir al menos una letra mayúscula, una letra minúscula y un número")
    private String password;

    @Past
    @Column(name = "fecha_nacimiento")
    @NotNull(message = "Este campo es obligatorio.")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;
    
    @Transient
    private String confirmarPassword;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String nombre, String apellido, String correo, String password, String confirmarPassword) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.confirmarPassword = confirmarPassword;
    }

    // Creando fechas antes de agregar a bd
    @PrePersist
    protected void onCreate() {
    this.fechaCreacion = LocalDate.now();
    this.fechaActualizacion = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
    this.fechaActualizacion = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

}
