
package Controller;

import EJB.DonacionesFacadeLocal;
import Entity.Adoptante;
import Entity.Donaciones;
import Entity.TipoDonacion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedDonaciones implements Serializable{
    
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
    public void init(){
        this.donaciones = new Donaciones();
        this.adoptante = new Adoptante();
        this.tipoDonacion = new TipoDonacion();
    }
    
    
}
