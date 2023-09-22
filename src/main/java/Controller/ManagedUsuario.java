
package Controller;

import EJB.UsuarioFacadeLocal;
import Entity.Rol;
import Entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class ManagedUsuario implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private Rol rol;
    private HttpServletRequest httpservelet;
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
        httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
    
    public String iniciarSesion(){
        System.out.println("Verificando usuario");
        String redireccion = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            usuario = usuarioFacade.acceder(usuario);
            if(usuario != null){
                context.getExternalContext().getSessionMap().put("usuario", usuario);
                redireccion = redireccionarUsuario(usuario.getRol_idRol().getIdRol());
            } else{
                FacesMessage message;
                message = new FacesMessage("Usuario y/o contraseña incorrecta.");
                context.addMessage(null, message);
                redireccion = "LoginAdministrativo";
            }
        }catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        return redireccion;
    }
    
    public String redireccionarUsuario(int rol){
        switch(rol){
            case 1:
                return "inicioAdmin";
            default:
            return "inicioVeter";
        }
    }
    
    public void cerrarSesion(){
        try{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("LoginAdministrativo.xhtml");
            this.msj = "Sesion cerrada correctamente";
        }catch(IOException e){
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
    }
    
    public void verificarSesion(int nivel) throws IOException{
        httpservelet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Usuario r = (Usuario) httpservelet.getSession().getAttribute("usuario");
        if(r != null){
            if(r.getRol_idRol().getIdRol() != nivel){
                FacesContext.getCurrentInstance().getExternalContext().redirect("Permisos.xhtml");
            }
        }else{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("Permisos.xhtml");
        }
    }
    
}
