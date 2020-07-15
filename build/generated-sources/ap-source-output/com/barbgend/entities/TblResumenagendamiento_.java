package com.barbgend.entities;

import com.barbgend.entities.TblAgendamiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblResumenagendamiento.class)
public class TblResumenagendamiento_ { 

    public static volatile SingularAttribute<TblResumenagendamiento, Float> resaPrecioTotal;
    public static volatile SingularAttribute<TblResumenagendamiento, TblAgendamiento> resaIdAgendamientoFk;
    public static volatile SingularAttribute<TblResumenagendamiento, Integer> resaIdResumen;

}