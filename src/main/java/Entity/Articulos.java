
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articulos")
public class Articulos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulos;
    @Column(name="nombreArticulo")
    private String nombreArticulo;
    @Column(name="descripcionArticulo")
    private String descripcionArticulo;
    @Column(name="referenciaArticulo")
    private String referenciaArticulo;
    @Column(name="stock")
    private String stock;
    @Column(name="estadoArticulo")
    private String estadoArticulo;
    

    public int getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getReferenciaArticulo() {
        return referenciaArticulo;
    }

    public void setReferenciaArticulo(String referenciaArticulo) {
        this.referenciaArticulo = referenciaArticulo;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getEstadoArticulo() {
        return estadoArticulo;
    }

    public void setEstadoArticulo(String estadoArticulo) {
        this.estadoArticulo = estadoArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idArticulos;
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
        final Articulos other = (Articulos) obj;
        return this.idArticulos == other.idArticulos;
    }

    @Override
    public String toString() {
        return "Articulos{" + "idArticulos=" + idArticulos + '}';
    }
    
}
