package com.barbgend.entities;

import com.barbgend.entities.TblRoles;
import com.barbgend.entities.TblUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblUsorol.class)
public class TblUsorol_ { 

    public static volatile SingularAttribute<TblUsorol, TblUsuario> tblUsuario;
    public static volatile SingularAttribute<TblUsorol, Integer> usrlIdUsuariorol;
    public static volatile SingularAttribute<TblUsorol, Date> usrlFechaIngreso;
    public static volatile SingularAttribute<TblUsorol, TblRoles> usrlIdRolFk;

}