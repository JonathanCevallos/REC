package com.uteq.rec.service;
import com.uteq.rec.entity.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uteq.rec.repository.ProyectoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    private ProyectoRepository ProyectoRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Proyecto> findAll() throws Exception {
        try {
            return ProyectoRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Proyecto findById(Integer id) throws Exception {
        try {
            Optional<Proyecto> entityOptional = ProyectoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Proyecto save(Proyecto entity) throws Exception {
        try {
            entity = ProyectoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Proyecto update(Integer id, Proyecto entity) throws Exception {
        try {
            Optional<Proyecto> entityOptional = ProyectoRepository.findById(id);
            Proyecto Proyecto = entityOptional.get();
            Proyecto = ProyectoRepository.save(entity);
            return Proyecto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (ProyectoRepository.existsById(id)) {
                ProyectoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
