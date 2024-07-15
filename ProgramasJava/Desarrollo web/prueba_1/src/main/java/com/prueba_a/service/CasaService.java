
package com.prueba_a.service;

import com.prueba_a.domain.Casa;
import java.util.List;

public interface CasaService  {
    
 
    public List<Casa> getCasas();
    
    public Casa getCasa(Casa casa);
    
    public void  save(Casa casa);
    
    public void  delete(Casa casa);


    
}
