/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServicio.findAll", query = "SELECT t FROM TblServicio t")
    , @NamedQuery(name = "TblServicio.findBySerIdServicio", query = "SELECT t FROM TblServicio t WHERE t.tblServicioPK.serIdServicio = :serIdServicio")
    , @NamedQuery(name = "TblServicio.findBySerIdAgendamientoFk", query = "SELECT t FROM TblServicio t WHERE t.tblServicioPK.serIdAgendamientoFk = :serIdAgendamientoFk")
    , @NamedQuery(name = "TblServicio.findBySerNombreServicio", query = "SELECT t FROM TblServicio t WHERE t.serNombreServicio = :serNombreServicio")
    , @NamedQuery(name = "TblServicio.findBySerTecnicaServicio", query = "SELECT t FROM TblServicio t WHERE t.serTecnicaServicio = :serTecnicaServicio")
    , @NamedQuery(name = "TblServicio.findBySerCostoServicio", query = "SELECT t FROM TblServicio t WHERE t.serCostoServicio = :serCostoServicio")})
public class TblServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblServicioPK tblServicioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SER_NOMBRE_SERVICIO")
    private String serNombreServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SER_TECNICA_SERVICIO")
    private String serTecnicaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_COSTO_SERVICIO")
    private float serCostoServicio;
    @JoinColumn(name = "SER_ID_AGENDAMIENTO_FK", referencedColumnName = "AGE_ID_AGENDAMIENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblAgendamiento tblAgendamiento;
    @JoinColumn(name = "SER_ID_BARBERO_FK", referencedColumnName = "USU_ID_USUARIO")
    @ManyToOne(optional = false)
    private TblUsuario serIdBarberoFk;

    public TblServicio() {
    }

    public TblServicio(TblServicioPK tblServicioPK) {
        this.tblServicioPK = tblServicioPK;
    }

    public TblServicio(TblServicioPK tblServicioPK, String serNombreServicio, String serTecnicaServicio, float serCostoServicio) {
        this.tblServicioPK = tblServicioPK;
        this.serNombreServicio = serNombreServicio;
        this.serTecnicaServicio = serTecnicaServicio;
        this.serCostoServicio = serCostoServicio;
    }

    public TblServicio(int serIdServicio, int serIdAgendamientoFk) {
        this.tblServicioPK = new TblServicioPK(serIdServicio, serIdAgendamientoFk);
    }

    public TblServicioPK getTblServicioPK() {
        return tblServicioPK;
    }

    public void setTblServicioPK(TblServicioPK tblServicioPK) {
        this.tblServicioPK = tblServicioPK;
    }

    public String getSerNombreServicio() {
        return serNombreServicio;
    }

    public void setSerNombreServicio(String serNombreServicio) {
        this.serNombreServicio = serNombreServicio;
    }

    public String getSerTecnicaServicio() {
        return serTecnicaServicio;
    }

    public void setSerTecnicaServicio(String serTecnicaServicio) {
        this.serTecnicaServicio = serTecnicaServicio;
    }

    public float getSerCostoServicio() {
        return serCostoServicio;
    }

    public void setSerCostoServicio(float serCostoServicio) {
        this.serCostoServicio = serCostoServicio;
    }

    public TblAgendamiento getTblAgendamiento() {
        return tblAgendamiento;
    }

    public void setTblAgendamiento(TblAgendamiento tblAgendamiento) {
        this.tblAgendamiento = tblAgendamiento;
    }

    public TblUsuario getSerIdBarberoFk() {
        return serIdBarberoFk;
    }

    public void setSerIdBarberoFk(TblUsuario serIdBarberoFk) {
        this.serIdBarberoFk = serIdBarberoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblServicioPK != null ? tblServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicio)) {
            return false;
        }
        TblServicio other = (TblServicio) object;
        if ((this.tblServicioPK == null && other.tblServicioPK != null) || (this.tblServicioPK != null && !this.tblServicioPK.equals(other.tblServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblServicio[ tblServicioPK=" + tblServicioPK + " ]";
    }
    
}
