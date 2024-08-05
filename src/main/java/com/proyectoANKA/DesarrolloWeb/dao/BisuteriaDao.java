
package com.proyectoANKA.DesarrolloWeb.dao;

import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import com.proyectoANKA.DesarrolloWeb.domain.Bisuteria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BisuteriaDao extends JpaRepository<Bisuteria, Long> {
    
     @Query(nativeQuery=true,
            value = "Select * FROM bisuteria a WHERE "
            + "a.nombre = :nombreInf"
            )
    public List<Bisuteria>
            consultaSQL(String nombreInf);
    
}
