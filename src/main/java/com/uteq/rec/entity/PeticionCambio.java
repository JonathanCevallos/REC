package com.uteq.rec.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "peticionCambio")
public class PeticionCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fechaRegistro;
    private String descripcionCambio;
    private String propositoCmbio;
    private String justificacionCambio;
    private String observaciones;

    private int prioridad;
    private String resultadosPrevistos;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    Proyecto proyecto;


    @OneToMany
    List<Artefacto> artefactos;



    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

}
