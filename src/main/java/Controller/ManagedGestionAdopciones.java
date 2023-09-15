
package Controller;

import EJB.GestionAdopcionesFacadeLocal;
import Entity.Adopciones;
import Entity.GestionAdopciones;
import Entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedGestionAdopciones implements Serializable{
    
    @EJB
    private GestionAdopcionesFacadeLocal gestionAdopcionesFacade;
    private List<GestionAdopciones> listaGestionAdopciones;
    private GestionAdopciones gestionAdopciones;
    private Usuario usuario;
    private Adopciones adopciones;
    private String msj;

    public List<GestionAdopciones> getListaGestionAdopciones() {
        this.listaGestionAdopciones = this.gestionAdopcionesFacade.findAll();
        return listaGestionAdopciones;
    }

    public void setListaGestionAdopciones(List<GestionAdopciones> listaGestionAdopciones) {
        this.listaGestionAdopciones = listaGestionAdopciones;
    }

    public GestionAdopciones getGestionAdopciones() {
        return gestionAdopciones;
    }

    public void setGestionAdopciones(GestionAdopciones gestionAdopciones) {
        this.gestionAdopciones = gestionAdopciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Adopciones getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(Adopciones adopciones) {
        this.adopciones = adopciones;
    }
    
    @PostConstruct
    public void init(){
        this.gestionAdopciones = new GestionAdopciones();
        this.usuario = new Usuario();
        this.adopciones = new Adopciones();
    }
    
}
