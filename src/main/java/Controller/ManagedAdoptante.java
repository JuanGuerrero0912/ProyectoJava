
package Controller;

import EJB.AdoptanteFacadeLocal;
import Entity.Adoptante;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class ManagedAdoptante implements Serializable{
    
    @EJB
    private AdoptanteFacadeLocal adoptanteFacade;
    private List<Adoptante> listaAdoptante;
    private Adoptante adoptante;
    private HttpServletRequest httpservelet;
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
        httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            adoptante = adoptanteFacade.acceder(adoptante);
            if (adoptante != null) {
                context.getExternalContext().getSessionMap().put("adoptante", adoptante);
                ruta = "inicioAdoptante";
            } else {
                FacesMessage message;
                message = new FacesMessage("Usuario y/o contraseña incorrecta.");
                context.addMessage(null, message);
                ruta = "LoginAdoptante";
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        return ruta;
    }
    
    public void cerrarSesion(){
        try{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("LoginAdoptante.xhtml");
            this.msj = "Sesion cerrada correctamente";
        }catch(IOException e){
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
    }
    
    public void verificarSesion(int id) throws IOException{
        httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Adoptante r = (Adoptante) httpservelet.getSession().getAttribute("adoptante");
        if(r != null){
            if(r.getIdAdoptante() != id){
                FacesContext.getCurrentInstance().getExternalContext().redirect("Permisos.xhtml");
            }
        }else{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("Permisos.xhtml");
        }
    }
}
