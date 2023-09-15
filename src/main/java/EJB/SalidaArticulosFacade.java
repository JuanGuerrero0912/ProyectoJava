/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Entity.SalidaArticulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class SalidaArticulosFacade extends AbstractFacade<SalidaArticulos> implements SalidaArticulosFacadeLocal {

    @PersistenceContext(unitName = "DoggyAtHome")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalidaArticulosFacade() {
        super(SalidaArticulos.class);
    }
    
}
