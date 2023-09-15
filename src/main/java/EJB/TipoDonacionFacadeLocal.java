/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.TipoDonacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface TipoDonacionFacadeLocal {

    void create(TipoDonacion tipoDonacion);

    void edit(TipoDonacion tipoDonacion);

    void remove(TipoDonacion tipoDonacion);

    TipoDonacion find(Object id);

    List<TipoDonacion> findAll();

    List<TipoDonacion> findRange(int[] range);

    int count();
    
}
