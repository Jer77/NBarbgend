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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_resumenproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblResumenproducto.findAll", query = "SELECT t FROM TblResumenproducto t")
    , @NamedQuery(name = "TblResumenproducto.findByRespIdResumen", query = "SELECT t FROM TblResumenproducto t WHERE t.tblResumenproductoPK.respIdResumen = :respIdResumen")
    , @NamedQuery(name = "TblResumenproducto.findByRespIdProductoFk", query = "SELECT t FROM TblResumenproducto t WHERE t.tblResumenproductoPK.respIdProductoFk = :respIdProductoFk")
    , @NamedQuery(name = "TblResumenproducto.findByRespCantidad", query = "SELECT t FROM TblResumenproducto t WHERE t.respCantidad = :respCantidad")
    , @NamedQuery(name = "TblResumenproducto.findByRespPrecioTotal", query = "SELECT t FROM TblResumenproducto t WHERE t.respPrecioTotal = :respPrecioTotal")})
public class TblResumenproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblResumenproductoPK tblResumenproductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESP_CANTIDAD")
    private int respCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESP_PRECIO_TOTAL")
    private float respPrecioTotal;
    @JoinColumn(name = "RESP_ID_CLIENTE_FK", referencedColumnName = "USU_ID_USUARIO")
    @ManyToOne(optional = false)
    private TblUsuario respIdClienteFk;
    @JoinColumn(name = "RESP_ID_PRODUCTO_FK", referencedColumnName = "PRO_ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProducto tblProducto;

    public TblResumenproducto() {
    }

    public TblResumenproducto(TblResumenproductoPK tblResumenproductoPK) {
        this.tblResumenproductoPK = tblResumenproductoPK;
    }

    public TblResumenproducto(TblResumenproductoPK tblResumenproductoPK, int respCantidad, float respPrecioTotal) {
        this.tblResumenproductoPK = tblResumenproductoPK;
        this.respCantidad = respCantidad;
        this.respPrecioTotal = respPrecioTotal;
    }

    public TblResumenproducto(int respIdResumen, int respIdProductoFk) {
        this.tblResumenproductoPK = new TblResumenproductoPK(respIdResumen, respIdProductoFk);
    }

    public TblResumenproductoPK getTblResumenproductoPK() {
        return tblResumenproductoPK;
    }

    public void setTblResumenproductoPK(TblResumenproductoPK tblResumenproductoPK) {
        this.tblResumenproductoPK = tblResumenproductoPK;
    }

    public int getRespCantidad() {
        return respCantidad;
    }

    public void setRespCantidad(int respCantidad) {
        this.respCantidad = respCantidad;
    }

    public float getRespPrecioTotal() {
        return respPrecioTotal;
    }

    public void setRespPrecioTotal(float respPrecioTotal) {
        this.respPrecioTotal = respPrecioTotal;
    }

    public TblUsuario getRespIdClienteFk() {
        return respIdClienteFk;
    }

    public void setRespIdClienteFk(TblUsuario respIdClienteFk) {
        this.respIdClienteFk = respIdClienteFk;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblResumenproductoPK != null ? tblResumenproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblResumenproducto)) {
            return false;
        }
        TblResumenproducto other = (TblResumenproducto) object;
        if ((this.tblResumenproductoPK == null && other.tblResumenproductoPK != null) || (this.tblResumenproductoPK != null && !this.tblResumenproductoPK.equals(other.tblResumenproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblResumenproducto[ tblResumenproductoPK=" + tblResumenproductoPK + " ]";
    }
    
}
