package org.tatanacho.springcloud.msvc.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tatanacho.springcloud.msvc.usuarios.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
