
package Controller;

import EJB.UsuarioFacadeLocal;
import Entity.Rol;
import Entity.Usuario;
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
public class ManagedUsuario implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private Rol rol;
    private String msj;

    public List<Usuario> getListaUsuario() {
        this.listaUsuario = this.usuarioFacade.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
        this.rol = new Rol();
    }
    
    public void registrar() {
        try {
            this.usuario.setRol_idRol(rol);
            this.usuarioFacade.create(usuario);
            this.msj = "Registro creado correctamente";
            this.usuario = new Usuario();
            this.rol = new Rol();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void limpiar(){
        this.usuario = new Usuario();
        this.rol = new Rol();
       
    }
    
    public void cargarDatos(Usuario us){
        this.rol.setIdRol(us.getRol_idRol().getIdRol());
        this.usuario = us;
    }
    
    public void actualizar(){
        try{
            this.usuario.setRol_idRol(rol);
            this.usuarioFacade.edit(usuario);
            this.msj = "Actualizado correctamente";
            this.usuario = new Usuario();
            this.rol = new Rol();
        }catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
   
    public void eliminar() {
        try {
            usuarioFacade.remove(usuario);
            listaUsuario = usuarioFacade.findAll();
            this.usuario = new Usuario();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
}
