package Entity;

import Entity.Mascota;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-19T00:11:47")
@StaticMetamodel(SolicitudAdopcion.class)
public class SolicitudAdopcion_ { 

    public static volatile SingularAttribute<SolicitudAdopcion, String> estado;
    public static volatile SingularAttribute<SolicitudAdopcion, Date> fechaSolicitud;
    public static volatile SingularAttribute<SolicitudAdopcion, Mascota> mascota_idMascota;
    public static volatile SingularAttribute<SolicitudAdopcion, String> documentoSolicitudAdopcion;
    public static volatile SingularAttribute<SolicitudAdopcion, String> estadoSolicitud;
    public static volatile SingularAttribute<SolicitudAdopcion, Integer> idSolicitudAdopcion;

}