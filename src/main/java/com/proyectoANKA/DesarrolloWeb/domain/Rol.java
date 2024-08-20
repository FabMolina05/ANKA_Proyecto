package com.proyectoANKA.DesarrolloWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")

public class Rol implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")

    private Long idRol;
    @Column(name = "id_Usuario")
    private Long idUsuario;

    @NotEmpty
    private String nombre;

}
