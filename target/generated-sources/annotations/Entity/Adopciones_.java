package Entity;

import Entity.Adoptante;
import Entity.Mascota;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-21T17:12:07")
@StaticMetamodel(Adopciones.class)
public class Adopciones_ { 

    public static volatile SingularAttribute<Adopciones, Date> fecha;
    public static volatile SingularAttribute<Adopciones, String> estadoAdopcion;
    public static volatile SingularAttribute<Adopciones, Mascota> mascota_idMascota;
    public static volatile SingularAttribute<Adopciones, Integer> idAdopciones;
    public static volatile SingularAttribute<Adopciones, Adoptante> adoptante_idAdoptante;

}