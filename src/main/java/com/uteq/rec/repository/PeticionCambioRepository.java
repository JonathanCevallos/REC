package com.uteq.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uteq.rec.entity.PeticionCambio;

@Repository
public interface PeticionCambioRepository extends JpaRepository<PeticionCambio, Integer>{

}
