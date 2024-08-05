
package com.proyectoANKA.DesarrolloWeb.dao;

import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import com.proyectoANKA.DesarrolloWeb.domain.Ceramica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CeramicaDao extends JpaRepository<Ceramica, Long> {
    
     @Query(nativeQuery=true,
            value = "Select * FROM ceramica a WHERE "
            + "a.nombre = :nombreInf"
            )
    public List<Ceramica>
            consultaSQL(String nombreInf);
    
}
