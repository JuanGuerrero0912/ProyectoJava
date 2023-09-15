/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entity.Articulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAPTOP
 */
@Local
public interface ArticulosFacadeLocal {

    void create(Articulos articulos);

    void edit(Articulos articulos);

    void remove(Articulos articulos);

    Articulos find(Object id);

    List<Articulos> findAll();

    List<Articulos> findRange(int[] range);

    int count();
    
}
