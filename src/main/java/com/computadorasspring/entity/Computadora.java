package com.computadorasspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_computadora")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marcaComputador;
    private String modeloComputador;
    private String marcaProcesador;
    private String velocidadProcesador;
    private String generacionProcesador;
    private String tipoRam;
    private String capacidadRam;
    private String tipoDisco;
    private String capacidadDisco;
    private String marcaGrafica;
    private String capacidadGrafica;
}
