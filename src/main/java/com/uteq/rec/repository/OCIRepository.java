package com.uteq.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uteq.rec.entity.OCI;

@Repository
public interface OCIRepository extends JpaRepository<OCI, Integer>{

}
