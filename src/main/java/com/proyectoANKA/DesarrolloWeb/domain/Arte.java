
package com.proyectoANKA.DesarrolloWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="arte")


public class Arte implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_arte")

    
    
    private Long idArte;
        private String nombre;

    private String descripcion;
    private double precio;
    private String rutaImagen;
    private boolean activo;
    
  
}