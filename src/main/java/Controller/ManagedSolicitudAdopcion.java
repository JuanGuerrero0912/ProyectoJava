
package Controller;

import EJB.SolicitudAdopcionFacadeLocal;
import Entity.Mascota;
import Entity.SolicitudAdopcion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedSolicitudAdopcion implements Serializable{
    
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
    public void init(){
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.mascota = new Mascota();
    }
    
}
