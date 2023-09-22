package Controller;

import EJB.SolicitudAdopcionFacadeLocal;
import Entity.Mascota;
import Entity.SolicitudAdopcion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class ManagedSolicitudAdopcion implements Serializable {

    @EJB
    private SolicitudAdopcionFacadeLocal solicitudAdopcionFacade;
    private List<SolicitudAdopcion> listaSolicitudAdopcion;
    private SolicitudAdopcion solicitudAdopcion;
    private UploadedFile file;
    private StreamedContent filePdf;
    private Mascota mascota;
    private String msj;

    public List<SolicitudAdopcion> getListaSolicitudAdopcion() {
        this.listaSolicitudAdopcion = this.solicitudAdopcionFacade.findAll();
        return listaSolicitudAdopcion;
    }

    public void setListaSolicitudAdopcion(List<SolicitudAdopcion> listaSolicitudAdopcion) {
        this.listaSolicitudAdopcion = listaSolicitudAdopcion;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
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

    public StreamedContent getFilePdf() {
        return filePdf;
    }

    public void setFilePdf(StreamedContent filePdf) {
        this.filePdf = filePdf;
    }

    @PostConstruct
    public void init() {
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.mascota = new Mascota();   
    }

    public void registrar() {
        String rutaCarpeta = "C:\\Users\\Danie\\Documents\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\solicitudes";
        //"C:\\Users\\LAPTOP\\Documents\\NetBeansProjects\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\solicitudes";
        try {
            this.solicitudAdopcion.setMascota_idMascota(mascota);
            solicitudAdopcion.setNombreSolicitud(file.getFileName());
            solicitudAdopcion.setDocumentoSolicitudAdopcion(file.getContent());
            this.solicitudAdopcionFacade.create(solicitudAdopcion);
            escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutaCarpeta, file.getFileName());
            this.msj = "Registro creado correctamente";
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.mascota = new Mascota();
        } catch (IOException e) {
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

    public void limpar() {
        this.solicitudAdopcion = new SolicitudAdopcion();
        this.mascota = new Mascota();
    }

    public void cargarDatos(SolicitudAdopcion us) {
        this.mascota.setIdMascota(us.getMascota_idMascota().getIdMascota());
        this.solicitudAdopcion = us;
    }

    public void actualizar() {
        String rutaCarpeta = "C:\\Users\\Danie\\Documents\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\solicitudes";
        //"C:\\Users\\LAPTOP\\Documents\\NetBeansProjects\\Doggy\\ProyectoJava\\src\\main\\webapp\\resources\\solicitudes";
        try {
            this.solicitudAdopcion.setMascota_idMascota(mascota);
            solicitudAdopcion.setNombreSolicitud(file.getFileName());
            solicitudAdopcion.setDocumentoSolicitudAdopcion(file.getContent());
            this.solicitudAdopcionFacade.edit(solicitudAdopcion);
            escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutaCarpeta, file.getFileName());
            this.msj = "Actualizado correctamente";
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.mascota = new Mascota();
        } catch (IOException e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar() {
        try {
            solicitudAdopcionFacade.remove(solicitudAdopcion);
            listaSolicitudAdopcion = solicitudAdopcionFacade.findAll();
            this.solicitudAdopcion = new SolicitudAdopcion();
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public ManagedSolicitudAdopcion() {
        filePdf = DefaultStreamedContent.builder()
                .name("SolicitudAdopcion.pdf")
                .contentType("image/pdf")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/solicitudes/plantillaSolicitud/SolicitudAdopcion.pdf"))
                .build();
    }
}
