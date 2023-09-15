package Entity;

import Entity.Adoptante;
import Entity.TipoDonacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-14T20:40:43")
@StaticMetamodel(Donaciones.class)
public class Donaciones_ { 

    public static volatile SingularAttribute<Donaciones, String> cantidadDonacion;
    public static volatile SingularAttribute<Donaciones, String> estadoDonacion;
    public static volatile SingularAttribute<Donaciones, Integer> idDonaciones;
    public static volatile SingularAttribute<Donaciones, Adoptante> adoptante_idAdoptante;
    public static volatile SingularAttribute<Donaciones, Date> fechaDonacion;
    public static volatile SingularAttribute<Donaciones, String> referencia;
    public static volatile SingularAttribute<Donaciones, TipoDonacion> tipoDonacion_idTipoDonacion;

}