package com.barbgend.entities;

import com.barbgend.entities.TblProducto;
import com.barbgend.entities.TblResumenproductoPK;
import com.barbgend.entities.TblUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblResumenproducto.class)
public class TblResumenproducto_ { 

    public static volatile SingularAttribute<TblResumenproducto, TblResumenproductoPK> tblResumenproductoPK;
    public static volatile SingularAttribute<TblResumenproducto, TblUsuario> respIdClienteFk;
    public static volatile SingularAttribute<TblResumenproducto, Float> respPrecioTotal;
    public static volatile SingularAttribute<TblResumenproducto, Integer> respCantidad;
    public static volatile SingularAttribute<TblResumenproducto, TblProducto> tblProducto;

}