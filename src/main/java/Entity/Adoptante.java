
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adoptante")
public class Adoptante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdoptante;
    
    @Column(name="nombresAdoptante")
    private String nombresAdoptante;
    @Column(name="apellidosAdoptante")
    private String apellidosAdoptante;
    @Column(name="tipoDocumento")
    private String tipoDocumento;
    @Column(name="documento")
    private String documento;
    @Column(name="usuario")
    private String usuario;
    @Column(name="contraseña")
    private String contraseña;
    @Column(name="confirmarContraseña")
    private String confirmarContraseña;
    @Column(name="celular")
    private String celular;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="direccion")
    private String direccion;
    @Column(name="correo")
    private String correo;
    @Column(name="estadoAdoptante")
    private String estadoAdoptante;

    public int getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(int idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public String getNombresAdoptante() {
        return nombresAdoptante;
    }

    public void setNombresAdoptante(String nombresAdoptante) {
        this.nombresAdoptante = nombresAdoptante;
    }

    public String getApellidosAdoptante() {
        return apellidosAdoptante;
    }

    public void setApellidosAdoptante(String apellidosAdoptante) {
        this.apellidosAdoptante = apellidosAdoptante;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstadoAdoptante() {
        return estadoAdoptante;
    }

    public void setEstadoAdoptante(String estadoAdoptante) {
        this.estadoAdoptante = estadoAdoptante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idAdoptante;
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
        final Adoptante other = (Adoptante) obj;
        return this.idAdoptante == other.idAdoptante;
    }

    @Override
    public String toString() {
        return "Adoptante{" + "idAdoptante=" + idAdoptante + '}';
    }
}
