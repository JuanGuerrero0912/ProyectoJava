
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
@Table(name="gestionarticulos")
public class GestionArticulos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGestionArticulos;
    @ManyToOne
    @JoinColumn(name="articulos_idArticulos")
    private Articulos articulos_idArticulos;
    @ManyToOne
    @JoinColumn(name="usuario_idUsuario")
    private Usuario usuario_idUsuario;

    public int getIdGestionArticulos() {
        return idGestionArticulos;
    }

    public void setIdGestionArticulos(int idGestionArticulos) {
        this.idGestionArticulos = idGestionArticulos;
    }

    public Articulos getArticulos_idArticulos() {
        return articulos_idArticulos;
    }

    public void setArticulos_idArticulos(Articulos articulos_idArticulos) {
        this.articulos_idArticulos = articulos_idArticulos;
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
        hash = 11 * hash + this.idGestionArticulos;
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
        final GestionArticulos other = (GestionArticulos) obj;
        return this.idGestionArticulos == other.idGestionArticulos;
    }

    @Override
    public String toString() {
        return "GestionArticulos{" + "idGestionArticulos=" + idGestionArticulos + '}';
    }
    
}
