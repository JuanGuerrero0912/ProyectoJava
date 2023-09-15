/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.SolicitudAdopcionPorAdoptante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface SolicitudAdopcionPorAdoptanteFacadeLocal {

    void create(SolicitudAdopcionPorAdoptante solicitudAdopcionPorAdoptante);

    void edit(SolicitudAdopcionPorAdoptante solicitudAdopcionPorAdoptante);

    void remove(SolicitudAdopcionPorAdoptante solicitudAdopcionPorAdoptante);

    SolicitudAdopcionPorAdoptante find(Object id);

    List<SolicitudAdopcionPorAdoptante> findAll();

    List<SolicitudAdopcionPorAdoptante> findRange(int[] range);

    int count();
    
}
