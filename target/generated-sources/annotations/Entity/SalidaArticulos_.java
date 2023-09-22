package Entity;

import Entity.Articulos;
import Entity.Salidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-22T15:28:07")
@StaticMetamodel(SalidaArticulos.class)
public class SalidaArticulos_ { 

    public static volatile SingularAttribute<SalidaArticulos, Salidas> salidas_idSalidas;
    public static volatile SingularAttribute<SalidaArticulos, String> estadoSalida;
    public static volatile SingularAttribute<SalidaArticulos, String> cantidadSalidas;
    public static volatile SingularAttribute<SalidaArticulos, Articulos> articulos_idArticulos;
    public static volatile SingularAttribute<SalidaArticulos, Integer> idSalidasArticulos;

}