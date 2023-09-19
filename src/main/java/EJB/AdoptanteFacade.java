/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Entity.Adoptante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class AdoptanteFacade extends AbstractFacade<Adoptante> implements AdoptanteFacadeLocal {

    @PersistenceContext(unitName = "DoggyAtHome")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdoptanteFacade() {
        super(Adoptante.class);
    }
    
    @Override
    public Adoptante acceder(Adoptante us){
        Adoptante adoptante=null;
        String consulta="";
        try{
            consulta="select u from Adoptante u where u.usuario=?1 and u.contraseña=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getContraseña());
            List<Adoptante> lista = query.getResultList();
            if(!lista.isEmpty()){
                adoptante=lista.get(0);
            }
           
        }catch(Exception e){
            throw e;
        }
       
        return adoptante;
    }
    
}