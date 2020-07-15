package com.barbgend.entities;

import com.barbgend.entities.TblEstadoagendamiento;
import com.barbgend.entities.TblResumenagendamiento;
import com.barbgend.entities.TblServicio;
import com.barbgend.entities.TblUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblAgendamiento.class)
public class TblAgendamiento_ { 

    public static volatile SingularAttribute<TblAgendamiento, Integer> ageIdAgendamiento;
    public static volatile SingularAttribute<TblAgendamiento, TblUsuario> ageIdClienteFk;
    public static volatile SingularAttribute<TblAgendamiento, TblEstadoagendamiento> ageIdEstadoFk;
    public static volatile SingularAttribute<TblAgendamiento, Date> ageFechaAgendamiento;
    public static volatile SingularAttribute<TblAgendamiento, Integer> ageCalificacionBarbero;
    public static volatile CollectionAttribute<TblAgendamiento, TblServicio> tblServicioCollection;
    public static volatile CollectionAttribute<TblAgendamiento, TblResumenagendamiento> tblResumenagendamientoCollection;

}