/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Entity.TipoDonacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class TipoDonacionFacade extends AbstractFacade<TipoDonacion> implements TipoDonacionFacadeLocal {

    @PersistenceContext(unitName = "DoggyAtHome")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDonacionFacade() {
        super(TipoDonacion.class);
    }
    
}
