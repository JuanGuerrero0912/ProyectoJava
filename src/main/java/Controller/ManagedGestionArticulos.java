package Controller;

import EJB.GestionArticulosFacadeLocal;
import Entity.Articulos;
import Entity.GestionArticulos;
import Entity.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedGestionArticulos implements Serializable {

    @EJB
    private GestionArticulosFacadeLocal gestionArticulosFacade;
    private List<GestionArticulos> listaGestionArticulos;
    private GestionArticulos gestionArticulos;
    private Articulos articulos;
    private Usuario usuario;
    private String msj;

    public List<GestionArticulos> getListaGestionArticulos() {
        this.listaGestionArticulos = this.gestionArticulosFacade.findAll();
        return listaGestionArticulos;
    }

    public void setListaGestionArticulos(List<GestionArticulos> listaGestionArticulos) {
        this.listaGestionArticulos = listaGestionArticulos;
    }

    public GestionArticulos getGestionArticulos() {
        return gestionArticulos;
    }

    public void setGestionArticulos(GestionArticulos gestionArticulos) {
        this.gestionArticulos = gestionArticulos;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.gestionArticulos = new GestionArticulos();
        this.articulos = new Articulos();
        this.usuario = new Usuario();
    }
    

}
