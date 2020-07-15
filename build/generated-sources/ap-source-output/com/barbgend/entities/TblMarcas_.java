package com.barbgend.entities;

import com.barbgend.entities.TblProducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblMarcas.class)
public class TblMarcas_ { 

    public static volatile CollectionAttribute<TblMarcas, TblProducto> tblProductoCollection;
    public static volatile SingularAttribute<TblMarcas, String> marNombreMarca;
    public static volatile SingularAttribute<TblMarcas, Integer> marIdMarca;

}