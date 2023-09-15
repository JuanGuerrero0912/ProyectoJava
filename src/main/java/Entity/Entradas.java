
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="entradas")
public class Entradas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntradas;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaEntrada")
    private Date fechaEntrada;

    public int getIdEntradas() {
        return idEntradas;
    }

    public void setIdEntradas(int idEntradas) {
        this.idEntradas = idEntradas;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idEntradas;
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
        final Entradas other = (Entradas) obj;
        return this.idEntradas == other.idEntradas;
    }

    @Override
    public String toString() {
        return "Entradas{" + "idEntradas=" + idEntradas + '}';
    }
    
}
