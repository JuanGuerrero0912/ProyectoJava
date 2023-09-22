package Entity;

import Entity.SolicitudAdopcion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-22T15:35:42")
@StaticMetamodel(SeguimientoProceso.class)
public class SeguimientoProceso_ { 

    public static volatile SingularAttribute<SeguimientoProceso, Date> fecha;
    public static volatile SingularAttribute<SeguimientoProceso, String> faseDelSeguimiento;
    public static volatile SingularAttribute<SeguimientoProceso, String> estado;
    public static volatile SingularAttribute<SeguimientoProceso, Integer> idSeguimientoProceso;
    public static volatile SingularAttribute<SeguimientoProceso, SolicitudAdopcion> solicitudAdopcion_idSolicitudAdopcion;
    public static volatile SingularAttribute<SeguimientoProceso, String> estadoSeguimiento;

}