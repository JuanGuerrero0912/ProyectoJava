
package Controller;

import EJB.ArticulosFacadeLocal;
import Entity.Articulos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedArticulos implements Serializable{
    
    @EJB
    private ArticulosFacadeLocal articulosFacade;
    private List<Articulos> listaArticulos;
    private Articulos articulos;
    private String msj;

    public List<Articulos> getListaArticulos() {
        this.listaArticulos = this.articulosFacade.findAll();
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    
    @PostConstruct
    public void init(){
        this.articulos = new Articulos();
    }
    
}
