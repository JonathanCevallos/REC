package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uteq.rec.entity.Artefacto;
import com.uteq.rec.repository.ArtefactoRepository;

@Service
@Transactional
public class ArtefactoService {

	@Autowired
    private ArtefactoRepository artefactoRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Artefacto> findAll() throws Exception {
        try {
            return artefactoRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Artefacto findById(Integer id) throws Exception {
        try {
            Optional<Artefacto> entityOptional = artefactoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Artefacto save(Artefacto entity) throws Exception {
        try {
            entity = artefactoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Artefacto update(Integer id, Artefacto entity) throws Exception {
        try {
            Optional<Artefacto> entityOptional = artefactoRepository.findById(id);
            Artefacto artefacto = entityOptional.get();
            artefacto = artefactoRepository.save(entity);
            return artefacto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (artefactoRepository.existsById(id)) {
            	artefactoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
