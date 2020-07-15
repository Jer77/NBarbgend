/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_estadoagendamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstadoagendamiento.findAll", query = "SELECT t FROM TblEstadoagendamiento t")
    , @NamedQuery(name = "TblEstadoagendamiento.findByEsaIdEstado", query = "SELECT t FROM TblEstadoagendamiento t WHERE t.esaIdEstado = :esaIdEstado")
    , @NamedQuery(name = "TblEstadoagendamiento.findByEsaStatus", query = "SELECT t FROM TblEstadoagendamiento t WHERE t.esaStatus = :esaStatus")})
public class TblEstadoagendamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESA_ID_ESTADO")
    private Integer esaIdEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESA_STATUS")
    private String esaStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageIdEstadoFk")
    private Collection<TblAgendamiento> tblAgendamientoCollection;

    public TblEstadoagendamiento() {
    }

    public TblEstadoagendamiento(Integer esaIdEstado) {
        this.esaIdEstado = esaIdEstado;
    }

    public TblEstadoagendamiento(Integer esaIdEstado, String esaStatus) {
        this.esaIdEstado = esaIdEstado;
        this.esaStatus = esaStatus;
    }

    public Integer getEsaIdEstado() {
        return esaIdEstado;
    }

    public void setEsaIdEstado(Integer esaIdEstado) {
        this.esaIdEstado = esaIdEstado;
    }

    public String getEsaStatus() {
        return esaStatus;
    }

    public void setEsaStatus(String esaStatus) {
        this.esaStatus = esaStatus;
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
        hash += (esaIdEstado != null ? esaIdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstadoagendamiento)) {
            return false;
        }
        TblEstadoagendamiento other = (TblEstadoagendamiento) object;
        if ((this.esaIdEstado == null && other.esaIdEstado != null) || (this.esaIdEstado != null && !this.esaIdEstado.equals(other.esaIdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblEstadoagendamiento[ esaIdEstado=" + esaIdEstado + " ]";
    }
    
}
