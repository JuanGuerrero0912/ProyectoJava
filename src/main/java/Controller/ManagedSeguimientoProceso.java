
package Controller;

import EJB.SeguimientoProcesoFacadeLocal;
import Entity.SeguimientoProceso;
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
    
    public void registrar() {
        try {
            this.seguimientoProceso.setSolicitudAdopcion_idSolicitudAdopcion(solicitudAdopcion);
            this.seguimientoProcesoFacade.create(seguimientoProceso);
            this.msj = "Registro creado correctamente";
            this.seguimientoProceso = new SeguimientoProceso();
            this.solicitudAdopcion = new SolicitudAdopcion();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void limpiar(){
        this.seguimientoProceso = new SeguimientoProceso();
        this.solicitudAdopcion = new SolicitudAdopcion();
    }
    
    public void cargarDatos(SeguimientoProceso us){
        this.solicitudAdopcion.setIdSolicitudAdopcion(us.getSolicitudAdopcion_idSolicitudAdopcion().getIdSolicitudAdopcion());
        this.seguimientoProceso = us;
    }
    
     public void actualizar(){
         try {
            this.seguimientoProceso.setSolicitudAdopcion_idSolicitudAdopcion(solicitudAdopcion);
            this.seguimientoProcesoFacade.edit(seguimientoProceso);
            this.msj = "Registro creado correctamente";
            this.seguimientoProceso = new SeguimientoProceso();
            this.solicitudAdopcion = new SolicitudAdopcion();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
     }
     
     public void eliminar(SeguimientoProceso eli) {
        try {
            seguimientoProcesoFacade.remove(eli);
            listaSeguimientoProceso = seguimientoProcesoFacade.findAll();
            this.seguimientoProceso = new SeguimientoProceso();
            this.msj = "Eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
}
