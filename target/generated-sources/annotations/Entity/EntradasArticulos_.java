package Entity;

import Entity.Articulos;
import Entity.Entradas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-22T15:35:42")
@StaticMetamodel(EntradasArticulos.class)
public class EntradasArticulos_ { 

    public static volatile SingularAttribute<EntradasArticulos, Entradas> entradas_idEntradas;
    public static volatile SingularAttribute<EntradasArticulos, Integer> idEntradasArticulos;
    public static volatile SingularAttribute<EntradasArticulos, Articulos> articulos_idArticulos;
    public static volatile SingularAttribute<EntradasArticulos, String> estadoEntrada;
    public static volatile SingularAttribute<EntradasArticulos, String> cantidadEntrada;

}