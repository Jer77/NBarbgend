package com.barbgend.entities;

import com.barbgend.entities.TblAgendamiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblEstadoagendamiento.class)
public class TblEstadoagendamiento_ { 

    public static volatile SingularAttribute<TblEstadoagendamiento, Integer> esaIdEstado;
    public static volatile SingularAttribute<TblEstadoagendamiento, String> esaStatus;
    public static volatile CollectionAttribute<TblEstadoagendamiento, TblAgendamiento> tblAgendamientoCollection;

}