package org.tatanacho.springcloud.mscv.cursos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tatanacho.springcloud.mscv.cursos.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
