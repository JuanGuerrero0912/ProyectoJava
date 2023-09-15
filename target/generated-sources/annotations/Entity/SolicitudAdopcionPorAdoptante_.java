package Entity;

import Entity.Adoptante;
import Entity.SolicitudAdopcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-14T20:40:43")
@StaticMetamodel(SolicitudAdopcionPorAdoptante.class)
public class SolicitudAdopcionPorAdoptante_ { 

    public static volatile SingularAttribute<SolicitudAdopcionPorAdoptante, SolicitudAdopcion> solicitudAdopcion_idSolicitudAdopcion;
    public static volatile SingularAttribute<SolicitudAdopcionPorAdoptante, Adoptante> adoptante_idAdoptante;
    public static volatile SingularAttribute<SolicitudAdopcionPorAdoptante, Integer> idSolicitudAdopcionPorAdoptante;

}