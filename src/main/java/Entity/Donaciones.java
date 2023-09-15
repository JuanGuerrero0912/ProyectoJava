
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
@Table(name="donaciones")
public class Donaciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonaciones;
    @ManyToOne
    @JoinColumn(name="tipoDonacion_idTipoDonacion")
    private TipoDonacion tipoDonacion_idTipoDonacion;
    @ManyToOne
    @JoinColumn(name="adoptante_idAdoptante")
    private Adoptante adoptante_idAdoptante;
    @Column(name="cantidadDonacion")
    private String cantidadDonacion;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaDonacion")
    private Date fechaDonacion;
    @Column(name="referencia")
    private String referencia;
    @Column(name="estadoDonacion")
    private String estadoDonacion;

    public int getIdDonaciones() {
        return idDonaciones;
    }

    public void setIdDonaciones(int idDonaciones) {
        this.idDonaciones = idDonaciones;
    }

    public TipoDonacion getTipoDonacion_idTipoDonacion() {
        return tipoDonacion_idTipoDonacion;
    }

    public void setTipoDonacion_idTipoDonacion(TipoDonacion tipoDonacion_idTipoDonacion) {
        this.tipoDonacion_idTipoDonacion = tipoDonacion_idTipoDonacion;
    }

    public Adoptante getAdoptante_idAdoptante() {
        return adoptante_idAdoptante;
    }

    public void setAdoptante_idAdoptante(Adoptante adoptante_idAdoptante) {
        this.adoptante_idAdoptante = adoptante_idAdoptante;
    }

    public String getCantidadDonacion() {
        return cantidadDonacion;
    }

    public void setCantidadDonacion(String cantidadDonacion) {
        this.cantidadDonacion = cantidadDonacion;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstadoDonacion() {
        return estadoDonacion;
    }

    public void setEstadoDonacion(String estadoDonacion) {
        this.estadoDonacion = estadoDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idDonaciones;
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
        final Donaciones other = (Donaciones) obj;
        return this.idDonaciones == other.idDonaciones;
    }

    @Override
    public String toString() {
        return "Donaciones{" + "idDonaciones=" + idDonaciones + '}';
    }
}
