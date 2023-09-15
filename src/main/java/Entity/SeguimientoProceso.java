
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
@Table(name="seguimientoproceso")
public class SeguimientoProceso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeguimientoProceso;
    @Column(name="faseDelSeguimiento")
    private String faseDelSeguimiento;
    @Column(name="estado")
    private String estado;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="solicitudAdopcion_idSolicitudAdopcion")
    private SolicitudAdopcion solicitudAdopcion_idSolicitudAdopcion;
    @Column(name="estadoSeguimiento")
    private String estadoSeguimiento;

    public int getIdSeguimientoProceso() {
        return idSeguimientoProceso;
    }

    public void setIdSeguimientoProceso(int idSeguimientoProceso) {
        this.idSeguimientoProceso = idSeguimientoProceso;
    }

    public String getFaseDelSeguimiento() {
        return faseDelSeguimiento;
    }

    public void setFaseDelSeguimiento(String faseDelSeguimiento) {
        this.faseDelSeguimiento = faseDelSeguimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SolicitudAdopcion getSolicitudAdopcion_idSolicitudAdopcion() {
        return solicitudAdopcion_idSolicitudAdopcion;
    }

    public void setSolicitudAdopcion_idSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion_idSolicitudAdopcion) {
        this.solicitudAdopcion_idSolicitudAdopcion = solicitudAdopcion_idSolicitudAdopcion;
    }

    public String getEstadoSeguimiento() {
        return estadoSeguimiento;
    }

    public void setEstadoSeguimiento(String estadoSeguimiento) {
        this.estadoSeguimiento = estadoSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idSeguimientoProceso;
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
        final SeguimientoProceso other = (SeguimientoProceso) obj;
        return this.idSeguimientoProceso == other.idSeguimientoProceso;
    }

    @Override
    public String toString() {
        return "SeguimientoProceso{" + "idSeguimientoProceso=" + idSeguimientoProceso + '}';
    }
    
    
}
