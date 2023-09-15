/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.GestionArticulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface GestionArticulosFacadeLocal {

    void create(GestionArticulos gestionArticulos);

    void edit(GestionArticulos gestionArticulos);

    void remove(GestionArticulos gestionArticulos);

    GestionArticulos find(Object id);

    List<GestionArticulos> findAll();

    List<GestionArticulos> findRange(int[] range);

    int count();
    
}
