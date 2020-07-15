/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_resumenagendamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblResumenagendamiento.findAll", query = "SELECT t FROM TblResumenagendamiento t")
    , @NamedQuery(name = "TblResumenagendamiento.findByResaIdResumen", query = "SELECT t FROM TblResumenagendamiento t WHERE t.resaIdResumen = :resaIdResumen")
    , @NamedQuery(name = "TblResumenagendamiento.findByResaPrecioTotal", query = "SELECT t FROM TblResumenagendamiento t WHERE t.resaPrecioTotal = :resaPrecioTotal")})
public class TblResumenagendamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESA_ID_RESUMEN")
    private Integer resaIdResumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESA_PRECIO_TOTAL")
    private float resaPrecioTotal;
    @JoinColumn(name = "RESA_ID_AGENDAMIENTO_FK", referencedColumnName = "AGE_ID_AGENDAMIENTO")
    @ManyToOne(optional = false)
    private TblAgendamiento resaIdAgendamientoFk;

    public TblResumenagendamiento() {
    }

    public TblResumenagendamiento(Integer resaIdResumen) {
        this.resaIdResumen = resaIdResumen;
    }

    public TblResumenagendamiento(Integer resaIdResumen, float resaPrecioTotal) {
        this.resaIdResumen = resaIdResumen;
        this.resaPrecioTotal = resaPrecioTotal;
    }

    public Integer getResaIdResumen() {
        return resaIdResumen;
    }

    public void setResaIdResumen(Integer resaIdResumen) {
        this.resaIdResumen = resaIdResumen;
    }

    public float getResaPrecioTotal() {
        return resaPrecioTotal;
    }

    public void setResaPrecioTotal(float resaPrecioTotal) {
        this.resaPrecioTotal = resaPrecioTotal;
    }

    public TblAgendamiento getResaIdAgendamientoFk() {
        return resaIdAgendamientoFk;
    }

    public void setResaIdAgendamientoFk(TblAgendamiento resaIdAgendamientoFk) {
        this.resaIdAgendamientoFk = resaIdAgendamientoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resaIdResumen != null ? resaIdResumen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblResumenagendamiento)) {
            return false;
        }
        TblResumenagendamiento other = (TblResumenagendamiento) object;
        if ((this.resaIdResumen == null && other.resaIdResumen != null) || (this.resaIdResumen != null && !this.resaIdResumen.equals(other.resaIdResumen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblResumenagendamiento[ resaIdResumen=" + resaIdResumen + " ]";
    }
    
}
