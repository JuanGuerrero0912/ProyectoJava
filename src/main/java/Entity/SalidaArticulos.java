
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
@Table(name="salidas_articulos")
public class SalidaArticulos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalidasArticulos;
    @ManyToOne
    @JoinColumn(name="articulos_idArticulos")
    private Articulos articulos_idArticulos;
    @ManyToOne
    @JoinColumn(name="salidas_idSalidas")
    private Salidas salidas_idSalidas;
    @Column(name="cantidadSalidas")
    private String cantidadSalidas;
    @Column(name="estadoSalida")
    private String estadoSalida;

    public int getIdSalidasArticulos() {
        return idSalidasArticulos;
    }

    public void setIdSalidasArticulos(int idSalidasArticulos) {
        this.idSalidasArticulos = idSalidasArticulos;
    }

    public Articulos getArticulos_idArticulos() {
        return articulos_idArticulos;
    }

    public void setArticulos_idArticulos(Articulos articulos_idArticulos) {
        this.articulos_idArticulos = articulos_idArticulos;
    }

    public Salidas getSalidas_idSalidas() {
        return salidas_idSalidas;
    }

    public void setSalidas_idSalidas(Salidas salidas_idSalidas) {
        this.salidas_idSalidas = salidas_idSalidas;
    }

    public String getCantidadSalidas() {
        return cantidadSalidas;
    }

    public void setCantidadSalidas(String cantidadSalidas) {
        this.cantidadSalidas = cantidadSalidas;
    }

    public String getEstadoSalida() {
        return estadoSalida;
    }

    public void setEstadoSalida(String estadoSalida) {
        this.estadoSalida = estadoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idSalidasArticulos;
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
        final SalidaArticulos other = (SalidaArticulos) obj;
        return this.idSalidasArticulos == other.idSalidasArticulos;
    }

    @Override
    public String toString() {
        return "SalidaArticulos{" + "idSalidasArticulos=" + idSalidasArticulos + '}';
    }
    
}
