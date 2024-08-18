package com.proyectoANKA.DesarrolloWeb.dao;

import com.proyectoANKA.DesarrolloWeb.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<Factura, Long> {

}
