package com.barbgend.entities;

import com.barbgend.entities.TblUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblCatalogobarbero.class)
public class TblCatalogobarbero_ { 

    public static volatile SingularAttribute<TblCatalogobarbero, byte[]> catImg;
    public static volatile SingularAttribute<TblCatalogobarbero, String> catDescripcion;
    public static volatile SingularAttribute<TblCatalogobarbero, Integer> catIdCatalogo;
    public static volatile SingularAttribute<TblCatalogobarbero, Date> catFechaIngreso;
    public static volatile SingularAttribute<TblCatalogobarbero, TblUsuario> catIdBarberoFk;

}