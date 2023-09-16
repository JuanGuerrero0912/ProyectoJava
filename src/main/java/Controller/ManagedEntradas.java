package Controller;

import EJB.EntradasFacadeLocal;
import Entity.Entradas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedEntradas implements Serializable {

    @EJB
    private EntradasFacadeLocal entradasFacade;
    private List<Entradas> listaEntradas;
    private Entradas entradas;
    private String msj;

    public List<Entradas> getListaEntradas() {
        this.listaEntradas = this.entradasFacade.findAll();
        return listaEntradas;
    }

    public void setListaEntradas(List<Entradas> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public Entradas getEntradas() {
        return entradas;
    }

    public void setEntradas(Entradas entradas) {
        this.entradas = entradas;
    }

    @PostConstruct
    public void init() {
        this.entradas = new Entradas();
    }
}
