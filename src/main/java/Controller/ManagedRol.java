
package Controller;

import EJB.RolFacadeLocal;
import Entity.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedRol implements Serializable{
    
    @EJB
    private RolFacadeLocal rolFacade;
    private List<Rol> listaRol;
    private Rol rol;
    private String msj;

    public List<Rol> getListaRol() {
        this.listaRol = this.rolFacade.findAll();
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        this.rol = new Rol();
    }
    
}
