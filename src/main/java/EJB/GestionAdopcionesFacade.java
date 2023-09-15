/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Entity.GestionAdopciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAPTOP
 */
@Stateless
public class GestionAdopcionesFacade extends AbstractFacade<GestionAdopciones> implements GestionAdopcionesFacadeLocal {

    @PersistenceContext(unitName = "DoggyAtHome")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionAdopcionesFacade() {
        super(GestionAdopciones.class);
    }
    
}
