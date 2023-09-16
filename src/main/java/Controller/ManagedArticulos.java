package Controller;

import EJB.ArticulosFacadeLocal;
import Entity.Articulos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedArticulos implements Serializable {

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
    public void init() {
        this.articulos = new Articulos();
    }

    public void registrar() {
        try {
            this.articulosFacade.create(articulos);
            this.msj = "Registro creado correctamente";
            this.articulos = new Articulos();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.articulos = new Articulos();
    }

    public void cargarDatos(Articulos arti) {
        this.articulos = arti;

    }

    public void actualizar() {
        try {
            this.articulosFacade.edit(articulos);
            this.msj = "Actualizado correctamente";
            this.articulos = new Articulos();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Articulos elim) {
        try {
            articulosFacade.remove(elim);
            listaArticulos = articulosFacade.findAll();
            this.articulos = new Articulos();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
