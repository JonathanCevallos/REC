package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uteq.rec.entity.OCI;
import com.uteq.rec.repository.OCIRepository;

@Service
@Transactional
public class OCIService {
	@Autowired
    private OCIRepository oCIRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<OCI> findAll() throws Exception {
        try {
            return oCIRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public OCI findById(Integer id) throws Exception {
        try {
            Optional<OCI> entityOptional = oCIRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public OCI save(OCI entity) throws Exception {
        try {
            entity = oCIRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public OCI update(Integer id, OCI entity) throws Exception {
        try {
            Optional<OCI> entityOptional = oCIRepository.findById(id);
            OCI oCI = entityOptional.get();
            oCI = oCIRepository.save(entity);
            return oCI;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (oCIRepository.existsById(id)) {
            	oCIRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
