
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
@Table(name="entradas_articulos")
public class EntradasArticulos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntradasArticulos;
    @ManyToOne
    @JoinColumn(name="articulos_idArticulos")
    private Articulos articulos_idArticulos;
    @ManyToOne
    @JoinColumn(name="entradas_idEntradas")
    private Entradas entradas_idEntradas;
    @Column(name="cantidadEntrada")
    private String cantidadEntrada;
    @Column(name="estadoEntrada")
    private String estadoEntrada;

    public int getIdEntradasArticulos() {
        return idEntradasArticulos;
    }

    public void setIdEntradasArticulos(int idEntradasArticulos) {
        this.idEntradasArticulos = idEntradasArticulos;
    }

    public Articulos getArticulos_idArticulos() {
        return articulos_idArticulos;
    }

    public void setArticulos_idArticulos(Articulos articulos_idArticulos) {
        this.articulos_idArticulos = articulos_idArticulos;
    }

    public Entradas getEntradas_idEntradas() {
        return entradas_idEntradas;
    }

    public void setEntradas_idEntradas(Entradas entradas_idEntradas) {
        this.entradas_idEntradas = entradas_idEntradas;
    }

    public String getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(String cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public String getEstadoEntrada() {
        return estadoEntrada;
    }

    public void setEstadoEntrada(String estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }
    
    
}
