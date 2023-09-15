
package Controller;

import EJB.AdopcionesFacadeLocal;
import Entity.Adopciones;
import Entity.Adoptante;
import Entity.Mascota;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedAdopciones implements Serializable{
    
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
    public void init(){
        this.adopciones = new Adopciones();
        this.adoptante = new Adoptante();
        this.mascota = new Mascota();
    }
    
}
