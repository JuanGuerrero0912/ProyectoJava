
package Controller;

import EJB.SeguimientoProcesoFacadeLocal;
import Entity.SeguimientoProceso;
import Entity.SolicitudAdopcion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedSeguimientoProceso implements Serializable{
    
    @EJB
    private SeguimientoProcesoFacadeLocal seguimientoProcesoFacade;
    private List<SeguimientoProceso> listaSeguimientoProceso;
    private SeguimientoProceso seguimientoProceso;
    private SolicitudAdopcion solicitudAdopcion;
    private String msj;

    public List<SeguimientoProceso> getListaSeguimientoProceso() {
        this.listaSeguimientoProceso = this.seguimientoProcesoFacade.findAll();
        return listaSeguimientoProceso;
    }

    public void setListaSeguimientoProceso(List<SeguimientoProceso> listaSeguimientoProceso) {
        this.listaSeguimientoProceso = listaSeguimientoProceso;
    }

    public SeguimientoProceso getSeguimientoProceso() {
        return seguimientoProceso;
    }

    public void setSeguimientoProceso(SeguimientoProceso seguimientoProceso) {
        this.seguimientoProceso = seguimientoProceso;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
    }
    
    @PostConstruct
    public void init(){
        this.seguimientoProceso = new SeguimientoProceso();
        this.solicitudAdopcion = new SolicitudAdopcion();
    }
    
}
