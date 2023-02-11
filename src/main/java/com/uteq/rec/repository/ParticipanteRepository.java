package com.uteq.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uteq.rec.entity.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
