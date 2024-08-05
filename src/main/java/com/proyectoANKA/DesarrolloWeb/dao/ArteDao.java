
package com.proyectoANKA.DesarrolloWeb.dao;

import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArteDao extends JpaRepository<Arte, Long> {
    
      @Query(nativeQuery=true,
            value = "Select * FROM arte a WHERE "
            + "a.nombre = :nombreInf"
            )
    public List<Arte>
            consultaSQL(String nombreInf);
    
}
