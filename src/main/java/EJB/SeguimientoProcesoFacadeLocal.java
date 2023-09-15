/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.SeguimientoProceso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface SeguimientoProcesoFacadeLocal {

    void create(SeguimientoProceso seguimientoProceso);

    void edit(SeguimientoProceso seguimientoProceso);

    void remove(SeguimientoProceso seguimientoProceso);

    SeguimientoProceso find(Object id);

    List<SeguimientoProceso> findAll();

    List<SeguimientoProceso> findRange(int[] range);

    int count();
    
}
