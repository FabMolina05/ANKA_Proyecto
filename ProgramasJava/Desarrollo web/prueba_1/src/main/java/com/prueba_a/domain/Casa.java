
package com.prueba_a.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



@Data
@Entity
@Table(name="casa")



public class Casa implements Serializable {
  
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_casa")
    
    
    
    
    
    private Long idCasa;
    private String modelo;
    private double precio;
    private int partesCasa;
    private String imagen;
    
    
    
    
}