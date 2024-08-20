package com.proyectoANKA.DesarrolloWeb.dao;

import com.proyectoANKA.DesarrolloWeb.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    
      //Ejemplo de una consulta usando JQUERY
      @Query(nativeQuery=true,
            value = "Select * FROM producto a WHERE "
            + "a.descripcion = :nombreInf"
            )
    public List<Producto>
            consultaSQL(String nombreInf);
    
}
