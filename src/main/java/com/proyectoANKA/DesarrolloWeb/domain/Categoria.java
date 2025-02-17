
package com.proyectoANKA.DesarrolloWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")


public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")

    
    
    private Long idCategoria;
    private String descripcion;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_categoria",updatable=false)
    List<Producto> productos;
    
}