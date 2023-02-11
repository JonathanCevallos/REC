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
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    //prodcut Owner
    @ManyToOne
    @JoinColumn(name = "id_administrador_cambios", nullable = false)
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    private String descripcion;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_incio", nullable = false)
    private Date fechaInicio;

    private Double presupuesto;

    private LocalDateTime fechaRegistro;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

}
