
package Controller;

import EJB.AdoptanteFacadeLocal;
import Entity.Adoptante;
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
public class ManagedAdoptante implements Serializable{
    
    @EJB
    private AdoptanteFacadeLocal adoptanteFacade;
    private List<Adoptante> listaAdoptante;
    private Adoptante adoptante;
    private String msj;

    public List<Adoptante> getListaAdoptante() {
        this.listaAdoptante = this.adoptanteFacade.findAll();
        return listaAdoptante;
    }

    public void setListaAdoptante(List<Adoptante> listaAdoptante) {
        this.listaAdoptante = listaAdoptante;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
    
    @PostConstruct
    public void init(){
        this.adoptante = new Adoptante();
    }
    
    public void registrarAdoptante(){
        try{
        this.adoptanteFacade.create(adoptante);
            this.msj = "Te has registrado correctamente";
            this.adoptante = new Adoptante();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void registrar() {
        try {
            this.adoptanteFacade.create(adoptante);
            this.msj = "Registro creado correctamente";
            this.adoptante = new Adoptante();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.adoptante = new Adoptante();
    }

    public void cargarDatos(Adoptante adop) {
        this.adoptante = adop;

    }

    public void actualizar() {
        try {
            this.adoptanteFacade.edit(adoptante);
            this.msj = "Actualizado correctamente";
            this.adoptante = new Adoptante();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar() {
        try {
            adoptanteFacade.remove(adoptante);
            listaAdoptante = adoptanteFacade.findAll();
            this.adoptante = new Adoptante();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public String validar() {
        String ruta = "";
        Adoptante valor;

        try {
            valor = this.adoptanteFacade.acceder(this.adoptante);
            if (valor != null) {
                System.out.println("per" + valor.getUsuario());
                ruta = "inicioAdoptante";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario NO registrado", "Admin"));
            }

        } catch (Exception e) {
            throw e;
        }
        return ruta;
    }
    
}
