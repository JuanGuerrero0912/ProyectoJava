
package Controller;

import EJB.TipoDonacionFacadeLocal;
import Entity.TipoDonacion;
import Entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedTipoDonacion implements Serializable{
    
    @EJB
    private TipoDonacionFacadeLocal tipoDonacionFacade;
    private List<TipoDonacion> listaTipoDonacion;
    private TipoDonacion tipoDonacion;
    private Usuario usuario;
    private String msj;

    public List<TipoDonacion> getListaTipoDonacion() {
        this.listaTipoDonacion = this.tipoDonacionFacade.findAll();
        return listaTipoDonacion;
    }

    public void setListaTipoDonacion(List<TipoDonacion> listaTipoDonacion) {
        this.listaTipoDonacion = listaTipoDonacion;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.tipoDonacion = new TipoDonacion();
        this.usuario = new Usuario();
    }
    
}
