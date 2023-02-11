package com.uteq.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uteq.rec.entity.ReporteCambio;

@Repository
public interface ReporteCambioRepository extends JpaRepository<ReporteCambio, Integer>{

}
