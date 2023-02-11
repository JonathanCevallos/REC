package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uteq.rec.entity.PeticionCambio;
import com.uteq.rec.repository.PeticionCambioRepository;

@Service
@Transactional
public class PeticionCambioService {
	@Autowired
    private PeticionCambioRepository peticionCambioRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<PeticionCambio> findAll() throws Exception {
        try {
            return peticionCambioRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public PeticionCambio findById(Integer id) throws Exception {
        try {
            Optional<PeticionCambio> entityOptional = peticionCambioRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public PeticionCambio save(PeticionCambio entity) throws Exception {
        try {
            entity = peticionCambioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public PeticionCambio update(Integer id, PeticionCambio entity) throws Exception {
        try {
            Optional<PeticionCambio> entityOptional = peticionCambioRepository.findById(id);
            PeticionCambio peticionCambio = entityOptional.get();
            peticionCambio = peticionCambioRepository.save(entity);
            return peticionCambio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (peticionCambioRepository.existsById(id)) {
            	peticionCambioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
