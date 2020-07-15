package com.barbgend.entities;

import com.barbgend.entities.TblAgendamiento;
import com.barbgend.entities.TblServicioPK;
import com.barbgend.entities.TblUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblServicio.class)
public class TblServicio_ { 

    public static volatile SingularAttribute<TblServicio, String> serTecnicaServicio;
    public static volatile SingularAttribute<TblServicio, Float> serCostoServicio;
    public static volatile SingularAttribute<TblServicio, String> serNombreServicio;
    public static volatile SingularAttribute<TblServicio, TblAgendamiento> tblAgendamiento;
    public static volatile SingularAttribute<TblServicio, TblServicioPK> tblServicioPK;
    public static volatile SingularAttribute<TblServicio, TblUsuario> serIdBarberoFk;

}