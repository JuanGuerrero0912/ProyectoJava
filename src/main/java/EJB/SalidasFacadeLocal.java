/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.Salidas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface SalidasFacadeLocal {

    void create(Salidas salidas);

    void edit(Salidas salidas);

    void remove(Salidas salidas);

    Salidas find(Object id);

    List<Salidas> findAll();

    List<Salidas> findRange(int[] range);

    int count();
    
}
