/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.Adoptante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface AdoptanteFacadeLocal {

    void create(Adoptante adoptante);

    void edit(Adoptante adoptante);

    void remove(Adoptante adoptante);

    Adoptante find(Object id);

    List<Adoptante> findAll();

    List<Adoptante> findRange(int[] range);

    int count();
    
}
