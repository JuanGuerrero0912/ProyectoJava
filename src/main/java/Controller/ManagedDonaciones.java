package Controller;

import EJB.DonacionesFacadeLocal;
import Entity.Adoptante;
import Entity.Donaciones;
import Entity.TipoDonacion;
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
public class ManagedDonaciones implements Serializable {

    @EJB
    private DonacionesFacadeLocal donacionesFacade;
    private List<Donaciones> listaDonaciones;
    private Donaciones donaciones;
    private Adoptante adoptante;
    private TipoDonacion tipoDonacion;
    private String msj;

    public List<Donaciones> getListaDonaciones() {
        this.listaDonaciones = this.donacionesFacade.findAll();
        return listaDonaciones;
    }

    public void setListaDonaciones(List<Donaciones> listaDonaciones) {
        this.listaDonaciones = listaDonaciones;
    }

    public Donaciones getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Donaciones donaciones) {
        this.donaciones = donaciones;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

   

    @PostConstruct
    public void init() {
        this.donaciones = new Donaciones();
        this.adoptante = new Adoptante();
        this.tipoDonacion = new TipoDonacion();
    }

    public void registrar() {
        try {
            this.donaciones.setTipoDonacion_idTipoDonacion(tipoDonacion);
            this.donaciones.setAdoptante_idAdoptante(adoptante);
            this.donacionesFacade.create(donaciones);
            this.msj = "Registro creado correctamente";
            this.donaciones = new Donaciones();
            this.tipoDonacion = new TipoDonacion();
            this.adoptante = new Adoptante();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void limpiar() {
        this.donaciones = new Donaciones();
        this.tipoDonacion = new TipoDonacion();
        this.adoptante = new Adoptante();
    }

    public void cargarDatos(Donaciones ent) {
        this.adoptante.setIdAdoptante(ent.getAdoptante_idAdoptante().getIdAdoptante());
        this.tipoDonacion.setIdTipoDonacion(ent.getTipoDonacion_idTipoDonacion().getIdTipoDonacion());
        this.donaciones = ent;
    }

    public void actualizar() {
        try {

            this.donaciones.setAdoptante_idAdoptante(adoptante);
            this.donaciones.setTipoDonacion_idTipoDonacion(tipoDonacion);
            this.donacionesFacade.edit(donaciones);
            this.msj = "Actualizado correctamente";
            this.donaciones = new Donaciones();
            this.adoptante = new Adoptante();
            this.tipoDonacion = new TipoDonacion();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void eliminar(Donaciones elim) {
        try {
            donacionesFacade.remove(elim);
            listaDonaciones = donacionesFacade.findAll();
            this.donaciones = new Donaciones();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
