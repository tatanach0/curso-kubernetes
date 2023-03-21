package org.tatanacho.springcloud.msvc.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tatanacho.springcloud.msvc.usuarios.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
