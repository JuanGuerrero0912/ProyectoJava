package Controller;

import EJB.AdopcionesFacadeLocal;
import Entity.Adopciones;
import Entity.Adoptante;
import Entity.Mascota;

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
public class ManagedAdopciones implements Serializable {

    @EJB
    private AdopcionesFacadeLocal adopcionesFacade;
    private List<Adopciones> listaAdopciones;
    private Adopciones adopciones;
    private Mascota mascota;
    private Adoptante adoptante;
    private String msj;

    public List<Adopciones> getListaAdopciones() {
        this.listaAdopciones = this.adopcionesFacade.findAll();
        return listaAdopciones;
    }

    public void setListaAdopciones(List<Adopciones> listaAdopciones) {
        this.listaAdopciones = listaAdopciones;
    }

    public Adopciones getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(Adopciones adopciones) {
        this.adopciones = adopciones;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    @PostConstruct
    public void init() {
        this.adopciones = new Adopciones();
        this.adoptante = new Adoptante();
        this.mascota = new Mascota();
    }

    public void registrar() {
        try {
            this.adopciones.setAdoptante_idAdoptante(adoptante);
            this.adopciones.setMascota_idMascota(mascota);
            this.adopcionesFacade.create(adopciones);
            this.msj = "Registro creado correctamente";
            this.adopciones = new Adopciones();
            this.adoptante = new Adoptante();
            this.mascota = new Mascota();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.adopciones = new Adopciones();
        this.adoptante = new Adoptante();
        this.mascota = new Mascota();
    }
    
    public void cargarDatos(Adopciones us){
        this.adoptante.setIdAdoptante(us.getAdoptante_idAdoptante().getIdAdoptante());
        this.mascota.setIdMascota(us.getMascota_idMascota().getIdMascota());
        this.adopciones = us;
    }
    
    public void actualizar(){
        try {
            this.adopciones.setAdoptante_idAdoptante(adoptante);
            this.adopciones.setMascota_idMascota(mascota);
            this.adopcionesFacade.edit(adopciones);
            this.msj = "Registro creado correctamente";
            this.adopciones = new Adopciones();
            this.adoptante = new Adoptante();
            this.mascota = new Mascota();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Adopciones eli) {
        try {
            adopcionesFacade.remove(eli);
            listaAdopciones = adopcionesFacade.findAll();
            this.adopciones = new Adopciones();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
