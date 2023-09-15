
package Controller;

import EJB.SolicitudAdopcionPorAdoptanteFacadeLocal;
import Entity.Adoptante;
import Entity.SolicitudAdopcion;
import Entity.SolicitudAdopcionPorAdoptante;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedSolicitudAdopcionPorAdoptante implements Serializable{
    
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
    public void init(){
        this.solicitudAdopcionPorAdoptante = new SolicitudAdopcionPorAdoptante();
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.adoptante = new Adoptante();
    }
    
    
}
