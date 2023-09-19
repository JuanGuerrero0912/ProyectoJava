package Controller;

import EJB.MascotaFacadeLocal;
import Entity.Mascota;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;
import org.apache.poi.util.IOUtils;

@ManagedBean
@SessionScoped
public class ManagedMascota implements Serializable {

    @EJB
    private MascotaFacadeLocal mascotaFacade;
    private List<Mascota> listaMascota;
    private Mascota mascota;
    private UploadedFile file;
    private String msj;

    public List<Mascota> getListaMascota() {
        this.listaMascota = this.mascotaFacade.findAll();
        return listaMascota;
    }

    public void setListaMascota(List<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    @PostConstruct
    public void init() {
        this.mascota = new Mascota();
    }

    public void registrar() {
        try {
            String rutaCarpeta = "C:\\Users\\LAPTOP\\Documents\\NetBeansProjects\\Doggy\\ProyectoJava\\src\\main\\webapp\\Resources\\Imagenes";
                mascota.setNombreFoto(file.getFileName());
                mascota.setFotoMascota(file.getContent());
                this.mascotaFacade.create(mascota);
                escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutaCarpeta, file.getFileName());
                this.msj = "Mascota creada correctamente";
                this.mascota = new Mascota();
        }catch (IOException e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }



    public void escribirBytes(byte[] bytes, String carpeta, String nombreFoto) {
        try {
            Path path = Paths.get(carpeta, nombreFoto);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiar() {
        this.mascota = new Mascota();
    }

    public void cargarDatos(Mascota us) {
        this.mascota = us;
    }

    public void actualizar() {
        try {
            this.mascotaFacade.edit(mascota);
            this.msj = "Actualizado correctamente";
            this.mascota = new Mascota();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar() {
        try {
            this.mascotaFacade.remove(mascota);
            listaMascota = mascotaFacade.findAll();
            this.mascota = new Mascota();
            this.msj = "Mascota eliminada correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
