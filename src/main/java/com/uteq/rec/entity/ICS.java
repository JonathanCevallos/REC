package com.uteq.rec.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ics")
public class ICS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    Proyecto proyecto;



}
