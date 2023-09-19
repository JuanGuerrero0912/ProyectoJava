
package Controller;

import EJB.EntradasArticulosFacadeLocal;
import Entity.Articulos;
import Entity.Entradas;
import Entity.EntradasArticulos;
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
    
    public void registrar() {
        try {
            this.entradasArticulos.setArticulos_idArticulos(articulos);
            this.entradasArticulos.setEntradas_idEntradas(entradas);
            this.entradasArticulosFacade.create(entradasArticulos);
            this.msj = "Registro creado correctamente";
            this.entradasArticulos = new EntradasArticulos();
            this.articulos = new Articulos();
            this.entradas = new Entradas();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void limpiar() {
        this.entradasArticulos = new EntradasArticulos();
        this.articulos = new Articulos();
        this.entradas = new Entradas();
    }
    public void cargarDatos(EntradasArticulos ent){
        this.articulos.setIdArticulos(ent.getArticulos_idArticulos().getIdArticulos());
        this.entradas.setIdEntradas(ent.getEntradas_idEntradas().getIdEntradas());
        this.entradasArticulos = ent;
       
    }
    
    public void actualizar(){
        try{
            
            this.entradasArticulos.setArticulos_idArticulos(articulos);
            this.entradasArticulos.setEntradas_idEntradas(entradas);
            this.entradasArticulosFacade.edit(entradasArticulos);
            this.msj = "Actualizado correctamente";
            this.entradasArticulos = new EntradasArticulos();
            this.articulos = new Articulos();
            this.entradas = new Entradas();
        }catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar() {
        try {
            entradasArticulosFacade.remove(entradasArticulos);
            listaEntradasArticulos = entradasArticulosFacade.findAll();
            this.entradasArticulos = new EntradasArticulos();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
