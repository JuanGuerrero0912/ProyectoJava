
package Controller;

import EJB.AdoptanteFacadeLocal;
import Entity.Adoptante;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
}
