package com.uteq.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uteq.rec.entity.Artefacto;

@Repository
public interface ArtefactoRepository extends JpaRepository<Artefacto, Integer>{

}
