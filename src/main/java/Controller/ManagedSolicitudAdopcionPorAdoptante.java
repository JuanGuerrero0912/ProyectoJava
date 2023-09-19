package Controller;

import EJB.SolicitudAdopcionPorAdoptanteFacadeLocal;
import Entity.Adoptante;
import Entity.SolicitudAdopcion;
import Entity.SolicitudAdopcionPorAdoptante;
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
public class ManagedSolicitudAdopcionPorAdoptante implements Serializable {

    @EJB
    private SolicitudAdopcionPorAdoptanteFacadeLocal solicitudAdopcionPorAdoptanteFacade;
    private List<SolicitudAdopcionPorAdoptante> listaSolicitudAdopcionPorAdoptante;
    private SolicitudAdopcionPorAdoptante solicitudAdopcionPorAdoptante;
    private Adoptante adoptante;
    private SolicitudAdopcion solicitudAdopcion;
    private String msj;

    public List<SolicitudAdopcionPorAdoptante> getListaSolicitudAdopcionPorAdoptante() {
        this.listaSolicitudAdopcionPorAdoptante = this.solicitudAdopcionPorAdoptanteFacade.findAll();
        return listaSolicitudAdopcionPorAdoptante;
    }

    public void setListaSolicitudAdopcionPorAdoptante(List<SolicitudAdopcionPorAdoptante> listaSolicitudAdopcionPorAdoptante) {
        this.listaSolicitudAdopcionPorAdoptante = listaSolicitudAdopcionPorAdoptante;
    }

    public SolicitudAdopcionPorAdoptante getSolicitudAdopcionPorAdoptante() {
        return solicitudAdopcionPorAdoptante;
    }

    public void setSolicitudAdopcionPorAdoptante(SolicitudAdopcionPorAdoptante solicitudAdopcionPorAdoptante) {
        this.solicitudAdopcionPorAdoptante = solicitudAdopcionPorAdoptante;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
    }

    @PostConstruct
    public void init() {
        this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.adoptante = new Adoptante();
    }

    public void registrar() {
        try {
            this.solicitudAdopcionPorAdoptante.setSolicitudAdopcion_idSolicitudAdopcion(solicitudAdopcion);
            this.solicitudAdopcionPorAdoptante.setAdoptante_idAdoptante(adoptante);
            this.solicitudAdopcionPorAdoptanteFacade.create(solicitudAdopcionPorAdoptante);
            this.msj = "Almacenado con exito";
            this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.adoptante = new Adoptante();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.adoptante = new Adoptante();
    }
    
    public void cargarDatos(SolicitudAdopcionPorAdoptante us){
        this.adoptante.setIdAdoptante(us.getAdoptante_idAdoptante().getIdAdoptante());
        this.solicitudAdopcion.setIdSolicitudAdopcion(us.getSolicitudAdopcion_idSolicitudAdopcion().getIdSolicitudAdopcion());
        this.solicitudAdopcionPorAdoptante = us;
    }
    
    public void actualizar(){
        try {
            this.solicitudAdopcionPorAdoptante.setSolicitudAdopcion_idSolicitudAdopcion(solicitudAdopcion);
            this.solicitudAdopcionPorAdoptante.setAdoptante_idAdoptante(adoptante);
            this.solicitudAdopcionPorAdoptanteFacade.edit(solicitudAdopcionPorAdoptante);
            this.msj = "Almacenado con exito";
            this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
            this.solicitudAdopcion = new SolicitudAdopcion();
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
            solicitudAdopcionPorAdoptanteFacade.remove(solicitudAdopcionPorAdoptante);
            listaSolicitudAdopcionPorAdoptante = solicitudAdopcionPorAdoptanteFacade.findAll();
            this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
