package com.barbgend.entities;

import com.barbgend.entities.TblUsorol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblRoles.class)
public class TblRoles_ { 

    public static volatile SingularAttribute<TblRoles, String> rolNombreRol;
    public static volatile CollectionAttribute<TblRoles, TblUsorol> tblUsorolCollection;
    public static volatile SingularAttribute<TblRoles, Integer> rolIdRol;

}