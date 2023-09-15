/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.EntradasArticulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface EntradasArticulosFacadeLocal {

    void create(EntradasArticulos entradasArticulos);

    void edit(EntradasArticulos entradasArticulos);

    void remove(EntradasArticulos entradasArticulos);

    EntradasArticulos find(Object id);

    List<EntradasArticulos> findAll();

    List<EntradasArticulos> findRange(int[] range);

    int count();
    
}
