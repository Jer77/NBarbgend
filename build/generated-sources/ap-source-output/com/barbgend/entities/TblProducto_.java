package com.barbgend.entities;

import com.barbgend.entities.TblMarcas;
import com.barbgend.entities.TblResumenproducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblProducto.class)
public class TblProducto_ { 

    public static volatile SingularAttribute<TblProducto, String> proNombreProducto;
    public static volatile CollectionAttribute<TblProducto, TblResumenproducto> tblResumenproductoCollection;
    public static volatile SingularAttribute<TblProducto, Integer> proIdProducto;
    public static volatile SingularAttribute<TblProducto, TblMarcas> proIdMarcaFk;
    public static volatile SingularAttribute<TblProducto, String> proDescripcionProducto;
    public static volatile SingularAttribute<TblProducto, String> proPresentacion;
    public static volatile SingularAttribute<TblProducto, Float> proPrecioUnitario;

}