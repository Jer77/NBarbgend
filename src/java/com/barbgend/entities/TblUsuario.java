/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t")
    , @NamedQuery(name = "TblUsuario.findByUsuIdUsuario", query = "SELECT t FROM TblUsuario t WHERE t.usuIdUsuario = :usuIdUsuario")
    , @NamedQuery(name = "TblUsuario.findByUsuPrimerNombre", query = "SELECT t FROM TblUsuario t WHERE t.usuPrimerNombre = :usuPrimerNombre")
    , @NamedQuery(name = "TblUsuario.findByUsuSegundoNombre", query = "SELECT t FROM TblUsuario t WHERE t.usuSegundoNombre = :usuSegundoNombre")
    , @NamedQuery(name = "TblUsuario.findByUsuPrimerApellido", query = "SELECT t FROM TblUsuario t WHERE t.usuPrimerApellido = :usuPrimerApellido")
    , @NamedQuery(name = "TblUsuario.findByUsuSegundoApellido", query = "SELECT t FROM TblUsuario t WHERE t.usuSegundoApellido = :usuSegundoApellido")
    , @NamedQuery(name = "TblUsuario.findByUsuPassword", query = "SELECT t FROM TblUsuario t WHERE t.usuPassword = :usuPassword")
    , @NamedQuery(name = "TblUsuario.findByUsuEmail", query = "SELECT t FROM TblUsuario t WHERE t.usuEmail = :usuEmail")
    , @NamedQuery(name = "TblUsuario.findByUsuFechaNacimiento", query = "SELECT t FROM TblUsuario t WHERE t.usuFechaNacimiento = :usuFechaNacimiento")
    , @NamedQuery(name = "TblUsuario.findByUsuTelefonoFijo", query = "SELECT t FROM TblUsuario t WHERE t.usuTelefonoFijo = :usuTelefonoFijo")
    , @NamedQuery(name = "TblUsuario.findByUsuTelefonoMovil", query = "SELECT t FROM TblUsuario t WHERE t.usuTelefonoMovil = :usuTelefonoMovil")
    , @NamedQuery(name = "TblUsuario.findByUsuNumeroDocumento", query = "SELECT t FROM TblUsuario t WHERE t.usuNumeroDocumento = :usuNumeroDocumento")
    , @NamedQuery(name = "TblUsuario.findByUsuStatus", query = "SELECT t FROM TblUsuario t WHERE t.usuStatus = :usuStatus")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID_USUARIO")
    private Integer usuIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_PRIMER_NOMBRE")
    private String usuPrimerNombre;
    @Size(max = 30)
    @Column(name = "USU_SEGUNDO_NOMBRE")
    private String usuSegundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_PRIMER_APELLIDO")
    private String usuPrimerApellido;
    @Size(max = 30)
    @Column(name = "USU_SEGUNDO_APELLIDO")
    private String usuSegundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_PASSWORD")
    private String usuPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USU_EMAIL")
    private String usuEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date usuFechaNacimiento;
    @Column(name = "USU_TELEFONO_FIJO")
    private Integer usuTelefonoFijo;
    @Column(name = "USU_TELEFONO_MOVIL")
    private BigInteger usuTelefonoMovil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_NUMERO_DOCUMENTO")
    private int usuNumeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "USU_STATUS")
    private String usuStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUsuario")
    private Collection<TblDocumentos> tblDocumentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serIdBarberoFk")
    private Collection<TblServicio> tblServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respIdClienteFk")
    private Collection<TblResumenproducto> tblResumenproductoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblUsuario")
    private TblUsorol tblUsorol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catIdBarberoFk")
    private Collection<TblCatalogobarbero> tblCatalogobarberoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageIdClienteFk")
    private Collection<TblAgendamiento> tblAgendamientoCollection;

    public TblUsuario() {
    }

    public TblUsuario(Integer usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public TblUsuario(Integer usuIdUsuario, String usuPrimerNombre, String usuPrimerApellido, String usuPassword, String usuEmail, Date usuFechaNacimiento, int usuNumeroDocumento, String usuStatus) {
        this.usuIdUsuario = usuIdUsuario;
        this.usuPrimerNombre = usuPrimerNombre;
        this.usuPrimerApellido = usuPrimerApellido;
        this.usuPassword = usuPassword;
        this.usuEmail = usuEmail;
        this.usuFechaNacimiento = usuFechaNacimiento;
        this.usuNumeroDocumento = usuNumeroDocumento;
        this.usuStatus = usuStatus;
    }

    public Integer getUsuIdUsuario() {
        return usuIdUsuario;
    }

    public void setUsuIdUsuario(Integer usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public String getUsuPrimerNombre() {
        return usuPrimerNombre;
    }

    public void setUsuPrimerNombre(String usuPrimerNombre) {
        this.usuPrimerNombre = usuPrimerNombre;
    }

    public String getUsuSegundoNombre() {
        return usuSegundoNombre;
    }

    public void setUsuSegundoNombre(String usuSegundoNombre) {
        this.usuSegundoNombre = usuSegundoNombre;
    }

    public String getUsuPrimerApellido() {
        return usuPrimerApellido;
    }

    public void setUsuPrimerApellido(String usuPrimerApellido) {
        this.usuPrimerApellido = usuPrimerApellido;
    }

    public String getUsuSegundoApellido() {
        return usuSegundoApellido;
    }

    public void setUsuSegundoApellido(String usuSegundoApellido) {
        this.usuSegundoApellido = usuSegundoApellido;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public Date getUsuFechaNacimiento() {
        return usuFechaNacimiento;
    }

    public void setUsuFechaNacimiento(Date usuFechaNacimiento) {
        this.usuFechaNacimiento = usuFechaNacimiento;
    }

    public Integer getUsuTelefonoFijo() {
        return usuTelefonoFijo;
    }

    public void setUsuTelefonoFijo(Integer usuTelefonoFijo) {
        this.usuTelefonoFijo = usuTelefonoFijo;
    }

    public BigInteger getUsuTelefonoMovil() {
        return usuTelefonoMovil;
    }

    public void setUsuTelefonoMovil(BigInteger usuTelefonoMovil) {
        this.usuTelefonoMovil = usuTelefonoMovil;
    }

    public int getUsuNumeroDocumento() {
        return usuNumeroDocumento;
    }

    public void setUsuNumeroDocumento(int usuNumeroDocumento) {
        this.usuNumeroDocumento = usuNumeroDocumento;
    }

    public String getUsuStatus() {
        return usuStatus;
    }

    public void setUsuStatus(String usuStatus) {
        this.usuStatus = usuStatus;
    }

    @XmlTransient
    public Collection<TblDocumentos> getTblDocumentosCollection() {
        return tblDocumentosCollection;
    }

    public void setTblDocumentosCollection(Collection<TblDocumentos> tblDocumentosCollection) {
        this.tblDocumentosCollection = tblDocumentosCollection;
    }

    @XmlTransient
    public Collection<TblServicio> getTblServicioCollection() {
        return tblServicioCollection;
    }

    public void setTblServicioCollection(Collection<TblServicio> tblServicioCollection) {
        this.tblServicioCollection = tblServicioCollection;
    }

    @XmlTransient
    public Collection<TblResumenproducto> getTblResumenproductoCollection() {
        return tblResumenproductoCollection;
    }

    public void setTblResumenproductoCollection(Collection<TblResumenproducto> tblResumenproductoCollection) {
        this.tblResumenproductoCollection = tblResumenproductoCollection;
    }

    public TblUsorol getTblUsorol() {
        return tblUsorol;
    }

    public void setTblUsorol(TblUsorol tblUsorol) {
        this.tblUsorol = tblUsorol;
    }

    @XmlTransient
    public Collection<TblCatalogobarbero> getTblCatalogobarberoCollection() {
        return tblCatalogobarberoCollection;
    }

    public void setTblCatalogobarberoCollection(Collection<TblCatalogobarbero> tblCatalogobarberoCollection) {
        this.tblCatalogobarberoCollection = tblCatalogobarberoCollection;
    }

    @XmlTransient
    public Collection<TblAgendamiento> getTblAgendamientoCollection() {
        return tblAgendamientoCollection;
    }

    public void setTblAgendamientoCollection(Collection<TblAgendamiento> tblAgendamientoCollection) {
        this.tblAgendamientoCollection = tblAgendamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdUsuario != null ? usuIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.usuIdUsuario == null && other.usuIdUsuario != null) || (this.usuIdUsuario != null && !this.usuIdUsuario.equals(other.usuIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblUsuario[ usuIdUsuario=" + usuIdUsuario + " ]";
    }
    
}
