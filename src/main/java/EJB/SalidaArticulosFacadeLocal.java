/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.SalidaArticulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface SalidaArticulosFacadeLocal {

    void create(SalidaArticulos salidaArticulos);

    void edit(SalidaArticulos salidaArticulos);

    void remove(SalidaArticulos salidaArticulos);

    SalidaArticulos find(Object id);

    List<SalidaArticulos> findAll();

    List<SalidaArticulos> findRange(int[] range);

    int count();
    
}
