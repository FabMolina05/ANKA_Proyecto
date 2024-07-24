
package com.proyectoANKA.DesarrolloWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="bisuteria")


public class Bisuteria implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bisuteria")

    
    
    private Long idBisuteria;
        private String nombre;

    private String descripcion;
        private double precio;

    private String rutaImagen;
    private boolean activo;
    
  
}