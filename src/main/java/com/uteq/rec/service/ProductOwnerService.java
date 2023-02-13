package com.uteq.rec.service;

import com.uteq.rec.entity.ProductOwner;
import com.uteq.rec.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductOwnerService {
    @Autowired
    private ProductOwnerRepository productOwnerRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<ProductOwner> findAll() throws Exception {
        try {
            return productOwnerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public ProductOwner findById(Integer id) throws Exception {
        try {
            Optional<ProductOwner> entityOptional = productOwnerRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public ProductOwner save(ProductOwner entity) throws Exception {
        try {
            entity = productOwnerRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public ProductOwner update(Integer id, ProductOwner entity) throws Exception {
        try {
            Optional<ProductOwner> entityOptional = productOwnerRepository.findById(id);
            ProductOwner ProductOwner = entityOptional.get();
            ProductOwner = productOwnerRepository.save(entity);
            return ProductOwner;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}