/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yenni rosalba
 */
@Embeddable
public class TblServicioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_ID_SERVICIO")
    private int serIdServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_ID_AGENDAMIENTO_FK")
    private int serIdAgendamientoFk;

    public TblServicioPK() {
    }

    public TblServicioPK(int serIdServicio, int serIdAgendamientoFk) {
        this.serIdServicio = serIdServicio;
        this.serIdAgendamientoFk = serIdAgendamientoFk;
    }

    public int getSerIdServicio() {
        return serIdServicio;
    }

    public void setSerIdServicio(int serIdServicio) {
        this.serIdServicio = serIdServicio;
    }

    public int getSerIdAgendamientoFk() {
        return serIdAgendamientoFk;
    }

    public void setSerIdAgendamientoFk(int serIdAgendamientoFk) {
        this.serIdAgendamientoFk = serIdAgendamientoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) serIdServicio;
        hash += (int) serIdAgendamientoFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicioPK)) {
            return false;
        }
        TblServicioPK other = (TblServicioPK) object;
        if (this.serIdServicio != other.serIdServicio) {
            return false;
        }
        if (this.serIdAgendamientoFk != other.serIdAgendamientoFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblServicioPK[ serIdServicio=" + serIdServicio + ", serIdAgendamientoFk=" + serIdAgendamientoFk + " ]";
    }
    
}
