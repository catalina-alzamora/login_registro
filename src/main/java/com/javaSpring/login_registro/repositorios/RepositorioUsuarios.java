package com.javaSpring.login_registro.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.login_registro.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>  {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
