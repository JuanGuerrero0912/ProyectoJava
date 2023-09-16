package Controller;

import EJB.SalidasFacadeLocal;
import Entity.Salidas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedSalidas implements Serializable {

    @EJB
    private SalidasFacadeLocal salidasFacade;
    private List<Salidas> listaSalidas;
    private Salidas salidas;
    private String msj;

    public List<Salidas> getListaSalidas() {
        this.listaSalidas = this.salidasFacade.findAll();
        return listaSalidas;
    }

    public void setListaSalidas(List<Salidas> listaSalidas) {
        this.listaSalidas = listaSalidas;
    }

    public Salidas getSalidas() {
        return salidas;
    }

    public void setSalidas(Salidas salidas) {
        this.salidas = salidas;
    }

    @PostConstruct
    public void init() {
        this.salidas = new Salidas();
    }

}
