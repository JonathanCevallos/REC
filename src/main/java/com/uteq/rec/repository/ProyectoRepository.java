package com.uteq.rec.repository;

import com.uteq.rec.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository  extends JpaRepository<Proyecto, Integer> {
}
