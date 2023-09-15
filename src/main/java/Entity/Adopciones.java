
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="adopciones")
public class Adopciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdopciones;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha")
    private Date fecha;
    @OneToOne
    @JoinColumn(name="mascota_idMascota")
    private Mascota mascota_idMascota;
    @Column(name="estadoAdopcion")
    private String estadoAdopcion;
    @ManyToOne
    @JoinColumn(name="adoptante_idAdoptante")
    private Adoptante adoptante_idAdoptante;

    public int getIdAdopciones() {
        return idAdopciones;
    }

    public void setIdAdopciones(int idAdopciones) {
        this.idAdopciones = idAdopciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mascota getMascota_idMascota() {
        return mascota_idMascota;
    }

    public void setMascota_idMascota(Mascota mascota_idMascota) {
        this.mascota_idMascota = mascota_idMascota;
    }

    public String getEstadoAdopcion() {
        return estadoAdopcion;
    }

    public void setEstadoAdopcion(String estadoAdopcion) {
        this.estadoAdopcion = estadoAdopcion;
    }

    public Adoptante getAdoptante_idAdoptante() {
        return adoptante_idAdoptante;
    }

    public void setAdoptante_idAdoptante(Adoptante adoptante_idAdoptante) {
        this.adoptante_idAdoptante = adoptante_idAdoptante;
    }
    
    
    
}
