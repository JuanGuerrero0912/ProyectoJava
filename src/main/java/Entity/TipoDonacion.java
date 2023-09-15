
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipodonacion")
public class TipoDonacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDonacion;
    @Column(name="nombreTipoDonacion")
    private String nombreTipoDonacion;
    @ManyToOne
    @JoinColumn(name="usuario_idUsuario")
    private Usuario usuario_idUsuario;

    public int getIdTipoDonacion() {
        return idTipoDonacion;
    }

    public void setIdTipoDonacion(int idTipoDonacion) {
        this.idTipoDonacion = idTipoDonacion;
    }

    public String getNombreTipoDonacion() {
        return nombreTipoDonacion;
    }

    public void setNombreTipoDonacion(String nombreTipoDonacion) {
        this.nombreTipoDonacion = nombreTipoDonacion;
    }

    public Usuario getUsuario_idUsuario() {
        return usuario_idUsuario;
    }

    public void setUsuario_idUsuario(Usuario usuario_idUsuario) {
        this.usuario_idUsuario = usuario_idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idTipoDonacion;
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
        final TipoDonacion other = (TipoDonacion) obj;
        return this.idTipoDonacion == other.idTipoDonacion;
    }

    @Override
    public String toString() {
        return "TipoDonacion{" + "idTipoDonacion=" + idTipoDonacion + '}';
    }
    
    
    
}
