package Entity;

import Entity.Mascota;
import Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-22T15:28:07")
@StaticMetamodel(HistorialMedico.class)
public class HistorialMedico_ { 

    public static volatile SingularAttribute<HistorialMedico, Date> fecha;
    public static volatile SingularAttribute<HistorialMedico, Mascota> mascota_idMascota;
    public static volatile SingularAttribute<HistorialMedico, byte[]> diagnostico;
    public static volatile SingularAttribute<HistorialMedico, Integer> idHistorialMedico;
    public static volatile SingularAttribute<HistorialMedico, String> nombrePdf;
    public static volatile SingularAttribute<HistorialMedico, Usuario> usuario_idUsuario;
    public static volatile SingularAttribute<HistorialMedico, String> estadoHistorialMedico;

}