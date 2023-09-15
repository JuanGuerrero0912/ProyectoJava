/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.SolicitudAdopcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface SolicitudAdopcionFacadeLocal {

    void create(SolicitudAdopcion solicitudAdopcion);

    void edit(SolicitudAdopcion solicitudAdopcion);

    void remove(SolicitudAdopcion solicitudAdopcion);

    SolicitudAdopcion find(Object id);

    List<SolicitudAdopcion> findAll();

    List<SolicitudAdopcion> findRange(int[] range);

    int count();
    
}
