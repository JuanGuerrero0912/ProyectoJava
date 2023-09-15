/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.Entradas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface EntradasFacadeLocal {

    void create(Entradas entradas);

    void edit(Entradas entradas);

    void remove(Entradas entradas);

    Entradas find(Object id);

    List<Entradas> findAll();

    List<Entradas> findRange(int[] range);

    int count();
    
}
