package Controller;

import EJB.HistorialMedicoFacadeLocal;
import Entity.HistorialMedico;
import Entity.Mascota;
import Entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class ManagedHistorialMedico implements Serializable {

    @EJB
    private HistorialMedicoFacadeLocal historialMedicoFacade;
    private List<HistorialMedico> listaHistorialMedico;
    private HistorialMedico historialMedico;
    private UploadedFile file;
    private Mascota mascota;
    private Usuario usuario;
    private String msj;

    public List<HistorialMedico> getListaHistorialMedico() {
        this.listaHistorialMedico = this.historialMedicoFacade.findAll();
        return listaHistorialMedico;
    }

    public void setListaHistorialMedico(List<HistorialMedico> listaHistorialMedico) {
        this.listaHistorialMedico = listaHistorialMedico;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    @PostConstruct
    public void init() {
        this.historialMedico = new HistorialMedico();
        this.mascota = new Mascota();
        this.usuario = new Usuario();
    }

    public void registrar() {
        String rutaCarpeta = "C:\\Users\\LAPTOP\\Documents\\NetBeansProjects\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\historial";
        try {
            this.historialMedico.setMascota_idMascota(mascota);
            this.historialMedico.setUsuario_idUsuario(usuario);
            historialMedico.setNombrePdf(file.getFileName());
            historialMedico.setDiagnostico(file.getContent());
            this.historialMedicoFacade.create(historialMedico);
            escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutaCarpeta, file.getFileName());
            this.msj = "Almacenado con exito";
            this.historialMedico = new HistorialMedico();
            this.mascota = new Mascota();
            this.usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void escribirBytes(byte[] bytes, String carpeta, String nombreImagen) {
        try {
            Path path = Paths.get(carpeta, nombreImagen);
            Files.write(path, bytes);
        } catch (IOException ex) {
            System.out.println("error al escribir los bytes" + ex.getMessage());
        }
    }

    public void limpiar() {
        this.historialMedico = new HistorialMedico();
        this.mascota = new Mascota();
        this.usuario = new Usuario();
    }

    public void cargarDatos(HistorialMedico us) {
        this.mascota.setIdMascota(us.getMascota_idMascota().getIdMascota());
        this.usuario.setIdUsuario(us.getUsuario_idUsuario().getIdUsuario());
        this.historialMedico = us;
    }

    public void actualizar() {
        String rutaCarpeta = "C:\\Users\\LAPTOP\\Documents\\NetBeansProjects\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\historial";
        try {
            this.historialMedico.setMascota_idMascota(mascota);
            this.historialMedico.setUsuario_idUsuario(usuario);
            historialMedico.setNombrePdf(file.getFileName());
            historialMedico.setDiagnostico(file.getContent());
            this.historialMedicoFacade.edit(historialMedico);
            escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutaCarpeta, file.getFileName());
            this.msj = "Almacenado con exito";
            this.historialMedico = new HistorialMedico();
            this.mascota = new Mascota();
            this.usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar() {

        try {
            historialMedicoFacade.remove(historialMedico);
            listaHistorialMedico = historialMedicoFacade.findAll();
            this.historialMedico = new HistorialMedico();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }
}
