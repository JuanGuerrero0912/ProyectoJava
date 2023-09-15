/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.HistorialMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface HistorialMedicoFacadeLocal {

    void create(HistorialMedico historialMedico);

    void edit(HistorialMedico historialMedico);

    void remove(HistorialMedico historialMedico);

    HistorialMedico find(Object id);

    List<HistorialMedico> findAll();

    List<HistorialMedico> findRange(int[] range);

    int count();
    
}
