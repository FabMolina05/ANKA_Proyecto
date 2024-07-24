
package com.proyectoANKA.DesarrolloWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="ceramica")


public class Ceramica implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ceramica")

    
    
    private Long idCeramica;
    private String nombre;
    private String descripcion;
        private double precio;

    private String rutaImagen;
    private boolean activo;
    
  
}