/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_agendamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAgendamiento.findAll", query = "SELECT t FROM TblAgendamiento t")
    , @NamedQuery(name = "TblAgendamiento.findByAgeIdAgendamiento", query = "SELECT t FROM TblAgendamiento t WHERE t.ageIdAgendamiento = :ageIdAgendamiento")
    , @NamedQuery(name = "TblAgendamiento.findByAgeFechaAgendamiento", query = "SELECT t FROM TblAgendamiento t WHERE t.ageFechaAgendamiento = :ageFechaAgendamiento")
    , @NamedQuery(name = "TblAgendamiento.findByAgeCalificacionBarbero", query = "SELECT t FROM TblAgendamiento t WHERE t.ageCalificacionBarbero = :ageCalificacionBarbero")})
public class TblAgendamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGE_ID_AGENDAMIENTO")
    private Integer ageIdAgendamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE_FECHA_AGENDAMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ageFechaAgendamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE_CALIFICACION_BARBERO")
    private int ageCalificacionBarbero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resaIdAgendamientoFk")
    private Collection<TblResumenagendamiento> tblResumenagendamientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAgendamiento")
    private Collection<TblServicio> tblServicioCollection;
    @JoinColumn(name = "AGE_ID_CLIENTE_FK", referencedColumnName = "USU_ID_USUARIO")
    @ManyToOne(optional = false)
    private TblUsuario ageIdClienteFk;
    @JoinColumn(name = "AGE_ID_ESTADO_FK", referencedColumnName = "ESA_ID_ESTADO")
    @ManyToOne(optional = false)
    private TblEstadoagendamiento ageIdEstadoFk;

    public TblAgendamiento() {
    }

    public TblAgendamiento(Integer ageIdAgendamiento) {
        this.ageIdAgendamiento = ageIdAgendamiento;
    }

    public TblAgendamiento(Integer ageIdAgendamiento, Date ageFechaAgendamiento, int ageCalificacionBarbero) {
        this.ageIdAgendamiento = ageIdAgendamiento;
        this.ageFechaAgendamiento = ageFechaAgendamiento;
        this.ageCalificacionBarbero = ageCalificacionBarbero;
    }

    public Integer getAgeIdAgendamiento() {
        return ageIdAgendamiento;
    }

    public void setAgeIdAgendamiento(Integer ageIdAgendamiento) {
        this.ageIdAgendamiento = ageIdAgendamiento;
    }

    public Date getAgeFechaAgendamiento() {
        return ageFechaAgendamiento;
    }

    public void setAgeFechaAgendamiento(Date ageFechaAgendamiento) {
        this.ageFechaAgendamiento = ageFechaAgendamiento;
    }

    public int getAgeCalificacionBarbero() {
        return ageCalificacionBarbero;
    }

    public void setAgeCalificacionBarbero(int ageCalificacionBarbero) {
        this.ageCalificacionBarbero = ageCalificacionBarbero;
    }

    @XmlTransient
    public Collection<TblResumenagendamiento> getTblResumenagendamientoCollection() {
        return tblResumenagendamientoCollection;
    }

    public void setTblResumenagendamientoCollection(Collection<TblResumenagendamiento> tblResumenagendamientoCollection) {
        this.tblResumenagendamientoCollection = tblResumenagendamientoCollection;
    }

    @XmlTransient
    public Collection<TblServicio> getTblServicioCollection() {
        return tblServicioCollection;
    }

    public void setTblServicioCollection(Collection<TblServicio> tblServicioCollection) {
        this.tblServicioCollection = tblServicioCollection;
    }

    public TblUsuario getAgeIdClienteFk() {
        return ageIdClienteFk;
    }

    public void setAgeIdClienteFk(TblUsuario ageIdClienteFk) {
        this.ageIdClienteFk = ageIdClienteFk;
    }

    public TblEstadoagendamiento getAgeIdEstadoFk() {
        return ageIdEstadoFk;
    }

    public void setAgeIdEstadoFk(TblEstadoagendamiento ageIdEstadoFk) {
        this.ageIdEstadoFk = ageIdEstadoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ageIdAgendamiento != null ? ageIdAgendamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAgendamiento)) {
            return false;
        }
        TblAgendamiento other = (TblAgendamiento) object;
        if ((this.ageIdAgendamiento == null && other.ageIdAgendamiento != null) || (this.ageIdAgendamiento != null && !this.ageIdAgendamiento.equals(other.ageIdAgendamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblAgendamiento[ ageIdAgendamiento=" + ageIdAgendamiento + " ]";
    }
    
}
