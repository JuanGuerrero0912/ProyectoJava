
package Controller;

import EJB.MascotaFacadeLocal;
import Entity.Mascota;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedMascota implements Serializable{
    
    @EJB
    private MascotaFacadeLocal mascotaFacade;
    private List<Mascota> listaMascota;
    private Mascota mascota;
    private String msj;

    public List<Mascota> getListaMascota() {
        this.listaMascota = this.mascotaFacade.findAll();
        return listaMascota;
    }

    public void setListaMascota(List<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
    @PostConstruct
    public void init(){
        this.mascota = new Mascota();
    }
    
}
