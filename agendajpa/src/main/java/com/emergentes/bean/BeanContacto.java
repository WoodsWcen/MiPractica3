
package com.emergentes.bean;

import com.emergentes.entidades.Contacto;
import com.emergentes.jpa.ContactoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanContacto {
    private EntityManagerFactory emf;
    private ContactoJpaController JpaContacto;

    public BeanContacto() {
        emf = Persistence.createEntityManagerFactory("UPagenda");
        JpaContacto = new ContactoJpaController(emf);
    }
    
    public List<Contacto> listarTodos(){
        return JpaContacto.findContactoEntities();
    }
    
        public void insertar(Contacto c){
        JpaContacto.create(c);
    }
        
        public void eliminar(Integer id){
        try {
            JpaContacto.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void editar(Contacto c){
        try {
            JpaContacto.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public Contacto buscar(Integer id){
            Contacto conta = new Contacto();
            
            conta = JpaContacto.findContacto(id);
            return conta;
        }
}
