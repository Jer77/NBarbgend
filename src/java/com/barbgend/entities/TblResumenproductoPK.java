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
public class TblResumenproductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "RESP_ID_RESUMEN")
    private int respIdResumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESP_ID_PRODUCTO_FK")
    private int respIdProductoFk;

    public TblResumenproductoPK() {
    }

    public TblResumenproductoPK(int respIdResumen, int respIdProductoFk) {
        this.respIdResumen = respIdResumen;
        this.respIdProductoFk = respIdProductoFk;
    }

    public int getRespIdResumen() {
        return respIdResumen;
    }

    public void setRespIdResumen(int respIdResumen) {
        this.respIdResumen = respIdResumen;
    }

    public int getRespIdProductoFk() {
        return respIdProductoFk;
    }

    public void setRespIdProductoFk(int respIdProductoFk) {
        this.respIdProductoFk = respIdProductoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) respIdResumen;
        hash += (int) respIdProductoFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblResumenproductoPK)) {
            return false;
        }
        TblResumenproductoPK other = (TblResumenproductoPK) object;
        if (this.respIdResumen != other.respIdResumen) {
            return false;
        }
        if (this.respIdProductoFk != other.respIdProductoFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblResumenproductoPK[ respIdResumen=" + respIdResumen + ", respIdProductoFk=" + respIdProductoFk + " ]";
    }
    
}
