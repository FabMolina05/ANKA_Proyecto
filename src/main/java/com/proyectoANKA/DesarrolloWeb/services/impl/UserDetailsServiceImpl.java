
package com.proyectoANKA.DesarrolloWeb.services.impl;

import com.proyectoANKA.DesarrolloWeb.services.UsuarioDetailsService;
import com.proyectoANKA.DesarrolloWeb.dao.UsuarioDao;
import com.proyectoANKA.DesarrolloWeb.domain.Rol;
import com.proyectoANKA.DesarrolloWeb.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl 
implements UsuarioDetailsService, UserDetailsService
        
{
    
     @Autowired
    private UsuarioDao usuarioDao;
     @Autowired
     private HttpSession session;
    

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if (usuario==null) {
            //no se encontro
            throw new UsernameNotFoundException(username);
        }
        
        //Si estamos aca si se encontro el usuario
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Se van a crear el objeto que contiene los roles del usuario
        
        var roles=new ArrayList<GrantedAuthority>();
        
        for (Rol r : usuario.getRoles()) {
            
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
            
        }
        
        //se retorna un usuario del sistema de seguridad
        
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
    
    
}
