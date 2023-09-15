
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="historialmedico")
public class HistorialMedico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialMedico;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha")
    private Date fecha;
    @Column(name="diagnostico")
    private String diagnostico;
    @ManyToOne
    @JoinColumn(name="mascota_idMascota")
    private Mascota mascota_idMascota;
    @ManyToOne
    @JoinColumn(name="usuario_idUsuario")
    private Usuario usuario_idUsuario;
    @Column(name="estadoHistorialMedico")
    private String estadoHistorialMedico;

    public int getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(int idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Mascota getMascota_idMascota() {
        return mascota_idMascota;
    }

    public void setMascota_idMascota(Mascota mascota_idMascota) {
        this.mascota_idMascota = mascota_idMascota;
    }

    public Usuario getUsuario_idUsuario() {
        return usuario_idUsuario;
    }

    public void setUsuario_idUsuario(Usuario usuario_idUsuario) {
        this.usuario_idUsuario = usuario_idUsuario;
    }

    public String getEstadoHistorialMedico() {
        return estadoHistorialMedico;
    }

    public void setEstadoHistorialMedico(String estadoHistorialMedico) {
        this.estadoHistorialMedico = estadoHistorialMedico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idHistorialMedico;
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
        final HistorialMedico other = (HistorialMedico) obj;
        return this.idHistorialMedico == other.idHistorialMedico;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" + "idHistorialMedico=" + idHistorialMedico + '}';
    }
    
    
    
}
