
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
@Table(name="salidas")
public class Salidas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalidas;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaSalida")
    private Date fechaSalida;

    public int getIdSalidas() {
        return idSalidas;
    }

    public void setIdSalidas(int idSalidas) {
        this.idSalidas = idSalidas;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idSalidas;
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
        final Salidas other = (Salidas) obj;
        return this.idSalidas == other.idSalidas;
    }

    @Override
    public String toString() {
        return "Salidas{" + "idSalidas=" + idSalidas + '}';
    }
    
    
}
