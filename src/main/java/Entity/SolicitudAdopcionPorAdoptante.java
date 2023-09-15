
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitudadopcion_por_adoptante")
public class SolicitudAdopcionPorAdoptante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitudAdopcionPorAdoptante;
    @ManyToOne
    @JoinColumn(name="adoptante_idAdoptante")
    private Adoptante adoptante_idAdoptante;
    @ManyToOne
    @JoinColumn(name="solicitudAdopcion_idSolicitudAdopcion")
    private SolicitudAdopcion solicitudAdopcion_idSolicitudAdopcion;

    public int getIdSolicitudAdopcionPorAdoptante() {
        return idSolicitudAdopcionPorAdoptante;
    }

    public void setIdSolicitudAdopcionPorAdoptante(int idSolicitudAdopcionPorAdoptante) {
        this.idSolicitudAdopcionPorAdoptante = idSolicitudAdopcionPorAdoptante;
    }

    public Adoptante getAdoptante_idAdoptante() {
        return adoptante_idAdoptante;
    }

    public void setAdoptante_idAdoptante(Adoptante adoptante_idAdoptante) {
        this.adoptante_idAdoptante = adoptante_idAdoptante;
    }

    public SolicitudAdopcion getSolicitudAdopcion_idSolicitudAdopcion() {
        return solicitudAdopcion_idSolicitudAdopcion;
    }

    public void setSolicitudAdopcion_idSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion_idSolicitudAdopcion) {
        this.solicitudAdopcion_idSolicitudAdopcion = solicitudAdopcion_idSolicitudAdopcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idSolicitudAdopcionPorAdoptante;
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
        final SolicitudAdopcionPorAdoptante other = (SolicitudAdopcionPorAdoptante) obj;
        return this.idSolicitudAdopcionPorAdoptante == other.idSolicitudAdopcionPorAdoptante;
    }

    @Override
    public String toString() {
        return "SolicitudAdopcionPorAdoptante{" + "idSolicitudAdopcionPorAdoptante=" + idSolicitudAdopcionPorAdoptante + '}';
    }
    
}
