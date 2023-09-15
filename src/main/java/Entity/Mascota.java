
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
@Table(name="mascota")
public class Mascota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMascota;
    @Column(name="nombre")
    private String nombre;
    @Column(name="caracteristicas")
    private String caracteristicas;
    @Column(name="estadoMascota")
    private String estadoMascota;
    @Column(name="sexo")
    private String sexo;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaIngreso")
    private Date fechaIngreso;
    @Column(name="edad")
    private String edad;
    @Column(name="fotoMascota")
    private String fotoMascota;
    @Column(name="raza")
    private String raza;
    @Column(name="estadoPerfilMascota")
    private String estadoPerfilMascota;

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(String estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(String fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEstadoPerfilMascota() {
        return estadoPerfilMascota;
    }

    public void setEstadoPerfilMascota(String estadoPerfilMascota) {
        this.estadoPerfilMascota = estadoPerfilMascota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idMascota;
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
        final Mascota other = (Mascota) obj;
        return this.idMascota == other.idMascota;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + '}';
    }
    
}
