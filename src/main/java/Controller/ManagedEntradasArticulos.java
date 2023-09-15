
package Controller;

import EJB.EntradasArticulosFacadeLocal;
import Entity.Articulos;
import Entity.Entradas;
import Entity.EntradasArticulos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedEntradasArticulos implements Serializable{
    
    @EJB
    private EntradasArticulosFacadeLocal entradasArticulosFacade;
    private List<EntradasArticulos> listaEntradasArticulos;
    private EntradasArticulos entradasArticulos;
    private Articulos articulos;
    private Entradas entradas;
    private String msj;

    public List<EntradasArticulos> getListaEntradasArticulos() {
        this.listaEntradasArticulos = this.entradasArticulosFacade.findAll();
        return listaEntradasArticulos;
    }

    public void setListaEntradasArticulos(List<EntradasArticulos> listaEntradasArticulos) {
        this.listaEntradasArticulos = listaEntradasArticulos;
    }

    public EntradasArticulos getEntradasArticulos() {
        return entradasArticulos;
    }

    public void setEntradasArticulos(EntradasArticulos entradasArticulos) {
        this.entradasArticulos = entradasArticulos;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public Entradas getEntradas() {
        return entradas;
    }

    public void setEntradas(Entradas entradas) {
        this.entradas = entradas;
    }
    
    @PostConstruct
    public void init(){
        this.entradasArticulos = new EntradasArticulos();
        this.entradas = new Entradas();
        this.articulos = new Articulos();
    }
}
