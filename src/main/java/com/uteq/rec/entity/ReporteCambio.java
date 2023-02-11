package com.uteq.rec.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reporteCambio")
public class ReporteCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_peticion_cambio", nullable = false)
    PeticionCambio peticionCambio;

    private boolean estado;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }
}
