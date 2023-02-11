package com.uteq.rec.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "oci")
public class OCI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fechaRegistro;
    private String identificacionOCI;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_incio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_finalizacion", nullable = false)
    private Date fechaFinalizacion;
    private int numeroSprintResolucion;
    @OneToMany
    private List<ICS> ics;
    private String planPruebas;

   //los desarolladores que van a trabajar
   @OneToMany
   List<Participante> participantes;



    //product Owner
    @ManyToOne
    @JoinColumn(name = "id_reporte_cambio", nullable = false)
    ReporteCambio reporteCambio;


    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }
}
