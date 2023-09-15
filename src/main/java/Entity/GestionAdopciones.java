
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
@Table(name="gestionadopciones")
public class GestionAdopciones implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGestionAdopciones;
    @ManyToOne
    @JoinColumn(name="usuario_idUsuario")
    private Usuario usuario_idUsuario;
    @ManyToOne
    @JoinColumn(name="adopciones_idAdopciones")
    private Adopciones adopciones_idAdopciones;

    public int getIdGestionAdopciones() {
        return idGestionAdopciones;
    }

    public void setIdGestionAdopciones(int idGestionAdopciones) {
        this.idGestionAdopciones = idGestionAdopciones;
    }

    public Usuario getUsuario_idUsuario() {
        return usuario_idUsuario;
    }

    public void setUsuario_idUsuario(Usuario usuario_idUsuario) {
        this.usuario_idUsuario = usuario_idUsuario;
    }

    public Adopciones getAdopciones_idAdopciones() {
        return adopciones_idAdopciones;
    }

    public void setAdopciones_idAdopciones(Adopciones adopciones_idAdopciones) {
        this.adopciones_idAdopciones = adopciones_idAdopciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idGestionAdopciones;
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
        final GestionAdopciones other = (GestionAdopciones) obj;
        return this.idGestionAdopciones == other.idGestionAdopciones;
    }

    @Override
    public String toString() {
        return "GestionAdopciones{" + "idGestionAdopciones=" + idGestionAdopciones + '}';
    }

    
    
    
}
