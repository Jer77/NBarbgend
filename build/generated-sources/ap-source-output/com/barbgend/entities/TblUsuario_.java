package com.barbgend.entities;

import com.barbgend.entities.TblAgendamiento;
import com.barbgend.entities.TblCatalogobarbero;
import com.barbgend.entities.TblDocumentos;
import com.barbgend.entities.TblResumenproducto;
import com.barbgend.entities.TblServicio;
import com.barbgend.entities.TblUsorol;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T19:22:12")
@StaticMetamodel(TblUsuario.class)
public class TblUsuario_ { 

    public static volatile CollectionAttribute<TblUsuario, TblResumenproducto> tblResumenproductoCollection;
    public static volatile SingularAttribute<TblUsuario, String> usuPrimerApellido;
    public static volatile CollectionAttribute<TblUsuario, TblDocumentos> tblDocumentosCollection;
    public static volatile CollectionAttribute<TblUsuario, TblCatalogobarbero> tblCatalogobarberoCollection;
    public static volatile CollectionAttribute<TblUsuario, TblServicio> tblServicioCollection;
    public static volatile CollectionAttribute<TblUsuario, TblAgendamiento> tblAgendamientoCollection;
    public static volatile SingularAttribute<TblUsuario, String> usuStatus;
    public static volatile SingularAttribute<TblUsuario, String> usuSegundoNombre;
    public static volatile SingularAttribute<TblUsuario, Date> usuFechaNacimiento;
    public static volatile SingularAttribute<TblUsuario, String> usuSegundoApellido;
    public static volatile SingularAttribute<TblUsuario, TblUsorol> tblUsorol;
    public static volatile SingularAttribute<TblUsuario, Integer> usuIdUsuario;
    public static volatile SingularAttribute<TblUsuario, String> usuEmail;
    public static volatile SingularAttribute<TblUsuario, Integer> usuTelefonoFijo;
    public static volatile SingularAttribute<TblUsuario, String> usuPrimerNombre;
    public static volatile SingularAttribute<TblUsuario, String> usuPassword;
    public static volatile SingularAttribute<TblUsuario, BigInteger> usuTelefonoMovil;
    public static volatile SingularAttribute<TblUsuario, Integer> usuNumeroDocumento;

}