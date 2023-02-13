package com.uteq.rec.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_owner")
public class ProductOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;

    private LocalDateTime fechaRegistro;
    //prodcut Owner

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

}
