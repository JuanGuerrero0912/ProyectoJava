package Controller;

import EJB.SalidaArticulosFacadeLocal;
import Entity.Articulos;
import Entity.SalidaArticulos;
import Entity.Salidas;
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
public class ManagedSalidaArticulos implements Serializable {

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
    public void init() {
        this.salidaArticulos = new SalidaArticulos();
        this.salidas = new Salidas();
        this.articulos = new Articulos();
    }

    public void registrar() {
        try {
            this.salidaArticulos.setArticulos_idArticulos(articulos);
            this.salidaArticulos.setSalidas_idSalidas(salidas);
            this.salidaArticulosFacade.create(salidaArticulos);
            this.msj = "Registro creado correctamente";
            this.salidaArticulos = new SalidaArticulos();
            this.articulos = new Articulos();
            this.salidas = new Salidas();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.salidaArticulos = new SalidaArticulos();
        this.articulos = new Articulos();
        this.salidas = new Salidas();
    }
    
    public void cargarDatos(SalidaArticulos sali){
        this.articulos.setIdArticulos(sali.getArticulos_idArticulos().getIdArticulos());
        this.salidas.setIdSalidas(sali.getSalidas_idSalidas().getIdSalidas());
        this.salidaArticulos = sali;
       
    }
    public void actualizar(){
        try{
            this.salidaArticulos.setArticulos_idArticulos(articulos);
            this.salidaArticulos.setSalidas_idSalidas(salidas);
            this.salidaArticulosFacade.edit(salidaArticulos);
            this.msj = "Actualizado correctamente";
            this.salidaArticulos = new SalidaArticulos();
            this.articulos = new Articulos();
            this.salidas = new Salidas();
        }catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar() {
        try {
            salidaArticulosFacade.remove(salidaArticulos);
            listaSalidaArticulos = salidaArticulosFacade.findAll();
            this.salidaArticulos = new SalidaArticulos();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
