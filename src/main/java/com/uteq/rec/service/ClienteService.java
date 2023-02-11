package com.uteq.rec.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uteq.rec.entity.Cliente;
import com.uteq.rec.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	@Autowired
    private ClienteRepository clienteRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Cliente> findAll() throws Exception {
        try {
            return clienteRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Cliente findById(Integer id) throws Exception {
        try {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Cliente save(Cliente entity) throws Exception {
        try {
            entity = clienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Cliente update(Integer id, Cliente entity) throws Exception {
        try {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            Cliente cliente = entityOptional.get();
            cliente = clienteRepository.save(entity);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (clienteRepository.existsById(id)) {
            	clienteRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
