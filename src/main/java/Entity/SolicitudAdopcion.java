
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="solicitudadopcion")
public class SolicitudAdopcion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitudAdopcion;
    @Column(name="estado")
    private String estado;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaSolicitud")
    private Date fechaSolicitud;
    @Column(name="nombreSolicitud")
    private String nombreSolicitud;
    @Lob
    @Column(name="documentoSolicitudAdopcion")
    private byte[] documentoSolicitudAdopcion;
    @ManyToOne
    @JoinColumn(name="mascota_idMascota")
    private Mascota mascota_idMascota;
    @Column(name="estadoSolicitud")
    private String estadoSolicitud;

    public int getIdSolicitudAdopcion() {
        return idSolicitudAdopcion;
    }

    public void setIdSolicitudAdopcion(int idSolicitudAdopcion) {
        this.idSolicitudAdopcion = idSolicitudAdopcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getNombreSolicitud() {
        return nombreSolicitud;
    }

    public void setNombreSolicitud(String nombreSolicitud) {
        this.nombreSolicitud = nombreSolicitud;
    }

    public byte[] getDocumentoSolicitudAdopcion() {
        return documentoSolicitudAdopcion;
    }

    public void setDocumentoSolicitudAdopcion(byte[] documentoSolicitudAdopcion) {
        this.documentoSolicitudAdopcion = documentoSolicitudAdopcion;
    }

    public Mascota getMascota_idMascota() {
        return mascota_idMascota;
    }

    public void setMascota_idMascota(Mascota mascota_idMascota) {
        this.mascota_idMascota = mascota_idMascota;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idSolicitudAdopcion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitudAdopcion other = (SolicitudAdopcion) obj;
        return this.idSolicitudAdopcion == other.idSolicitudAdopcion;
    }

    @Override
    public String toString() {
        return "SolicitudAdopcion{" + "idSolicitudAdopcion=" + idSolicitudAdopcion + '}';
    }
    
    
    
}
