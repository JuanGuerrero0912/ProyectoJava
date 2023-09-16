package Controller;

import EJB.SolicitudAdopcionFacadeLocal;
import Entity.Mascota;
import Entity.SolicitudAdopcion;
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
public class ManagedSolicitudAdopcion implements Serializable {

    @EJB
    private SolicitudAdopcionFacadeLocal solicitudAdopcionFacade;
    private List<SolicitudAdopcion> listaSolicitudAdopcion;
    private SolicitudAdopcion solicitudAdopcion;
    private Mascota mascota;
    private String msj;

    public List<SolicitudAdopcion> getListaSolicitudAdopcion() {
        this.listaSolicitudAdopcion = this.solicitudAdopcionFacade.findAll();
        return listaSolicitudAdopcion;
    }

    public void setListaSolicitudAdopcion(List<SolicitudAdopcion> listaSolicitudAdopcion) {
        this.listaSolicitudAdopcion = listaSolicitudAdopcion;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @PostConstruct
    public void init() {
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.mascota = new Mascota();
    }

    public void registrar() {
        try {
            this.solicitudAdopcion.setMascota_idMascota(mascota);
            this.solicitudAdopcionFacade.create(solicitudAdopcion);
            this.msj = "Registro creado correctamente";
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.mascota = new Mascota();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpar() {
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.mascota = new Mascota();
    }
    
    public void cargarDatos(SolicitudAdopcion us){
        this.mascota.setIdMascota(us.getMascota_idMascota().getIdMascota());
        this.solicitudAdopcion = us;
    }
    
    public void actualizar(){
        try {
            this.solicitudAdopcion.setMascota_idMascota(mascota);
            this.solicitudAdopcionFacade.edit(solicitudAdopcion);
            this.msj = "Actualizado correctamente";
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.mascota = new Mascota();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(SolicitudAdopcion eli) {
        try {
            solicitudAdopcionFacade.remove(eli);
            listaSolicitudAdopcion = solicitudAdopcionFacade.findAll();
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
