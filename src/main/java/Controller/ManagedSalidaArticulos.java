
package Controller;

import EJB.SalidaArticulosFacadeLocal;
import Entity.Articulos;
import Entity.SalidaArticulos;
import Entity.Salidas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedSalidaArticulos implements Serializable{
    
    @EJB
    private SalidaArticulosFacadeLocal salidaArticulosFacade;
    private List<SalidaArticulos> listaSalidaArticulos;
    private SalidaArticulos salidaArticulos;
    private Articulos articulos;
    private Salidas salidas;
    private String msj;

    public List<SalidaArticulos> getListaSalidaArticulos() {
        this.listaSalidaArticulos = this.salidaArticulosFacade.findAll();
        return listaSalidaArticulos;
    }

    public void setListaSalidaArticulos(List<SalidaArticulos> listaSalidaArticulos) {
        this.listaSalidaArticulos = listaSalidaArticulos;
    }

    public SalidaArticulos getSalidaArticulos() {
        return salidaArticulos;
    }

    public void setSalidaArticulos(SalidaArticulos salidaArticulos) {
        this.salidaArticulos = salidaArticulos;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public Salidas getSalidas() {
        return salidas;
    }

    public void setSalidas(Salidas salidas) {
        this.salidas = salidas;
    }
    
    @PostConstruct
    public void init(){
        this.salidaArticulos = new SalidaArticulos();
        this.salidas = new Salidas();
        this.articulos = new Articulos();
    }
    
}
