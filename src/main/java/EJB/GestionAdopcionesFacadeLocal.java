/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.GestionAdopciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface GestionAdopcionesFacadeLocal {

    void create(GestionAdopciones gestionAdopciones);

    void edit(GestionAdopciones gestionAdopciones);

    void remove(GestionAdopciones gestionAdopciones);

    GestionAdopciones find(Object id);

    List<GestionAdopciones> findAll();

    List<GestionAdopciones> findRange(int[] range);

    int count();
    
}
