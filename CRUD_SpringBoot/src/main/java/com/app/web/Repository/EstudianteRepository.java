package com.app.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.Entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
