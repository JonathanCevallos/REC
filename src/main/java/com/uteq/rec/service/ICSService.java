package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uteq.rec.entity.ICS;
import com.uteq.rec.repository.ICSRepository;

@Service
@Transactional
public class ICSService {
	@Autowired
    private ICSRepository iCSRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<ICS> findAll() throws Exception {
        try {
            return iCSRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public ICS findById(Integer id) throws Exception {
        try {
            Optional<ICS> entityOptional = iCSRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public ICS save(ICS entity) throws Exception {
        try {
            entity = iCSRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public ICS update(Integer id, ICS entity) throws Exception {
        try {
            Optional<ICS> entityOptional = iCSRepository.findById(id);
            ICS iCS = entityOptional.get();
            iCS = iCSRepository.save(entity);
            return iCS;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (iCSRepository.existsById(id)) {
            	iCSRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
