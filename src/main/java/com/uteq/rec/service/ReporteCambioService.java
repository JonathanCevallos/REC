package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uteq.rec.entity.ReporteCambio;
import com.uteq.rec.repository.ReporteCambioRepository;

@Service
@Transactional
public class ReporteCambioService {
	@Autowired
    private ReporteCambioRepository reporteCambioRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<ReporteCambio> findAll() throws Exception {
        try {
            return reporteCambioRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public ReporteCambio findById(Integer id) throws Exception {
        try {
            Optional<ReporteCambio> entityOptional = reporteCambioRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public ReporteCambio save(ReporteCambio entity) throws Exception {
        try {
            entity = reporteCambioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public ReporteCambio update(Integer id, ReporteCambio entity) throws Exception {
        try {
            Optional<ReporteCambio> entityOptional = reporteCambioRepository.findById(id);
            ReporteCambio reporteCambio = entityOptional.get();
            reporteCambio = reporteCambioRepository.save(entity);
            return reporteCambio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (reporteCambioRepository.existsById(id)) {
            	reporteCambioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
