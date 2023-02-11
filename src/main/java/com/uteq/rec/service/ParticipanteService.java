package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uteq.rec.entity.Participante;
import com.uteq.rec.repository.ParticipanteRepository;

@Service
@Transactional
public class ParticipanteService {
	@Autowired
    private ParticipanteRepository participanteRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Participante> findAll() throws Exception {
        try {
            return participanteRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Participante findById(Integer id) throws Exception {
        try {
            Optional<Participante> entityOptional = participanteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Participante save(Participante entity) throws Exception {
        try {
            entity = participanteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Participante update(Integer id, Participante entity) throws Exception {
        try {
            Optional<Participante> entityOptional = participanteRepository.findById(id);
            Participante participante = entityOptional.get();
            participante = participanteRepository.save(entity);
            return participante;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (participanteRepository.existsById(id)) {
            	participanteRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
