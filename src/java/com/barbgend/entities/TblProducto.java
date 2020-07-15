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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProducto.findAll", query = "SELECT t FROM TblProducto t")
    , @NamedQuery(name = "TblProducto.findByProIdProducto", query = "SELECT t FROM TblProducto t WHERE t.proIdProducto = :proIdProducto")
    , @NamedQuery(name = "TblProducto.findByProNombreProducto", query = "SELECT t FROM TblProducto t WHERE t.proNombreProducto = :proNombreProducto")
    , @NamedQuery(name = "TblProducto.findByProPrecioUnitario", query = "SELECT t FROM TblProducto t WHERE t.proPrecioUnitario = :proPrecioUnitario")
    , @NamedQuery(name = "TblProducto.findByProDescripcionProducto", query = "SELECT t FROM TblProducto t WHERE t.proDescripcionProducto = :proDescripcionProducto")
    , @NamedQuery(name = "TblProducto.findByProPresentacion", query = "SELECT t FROM TblProducto t WHERE t.proPresentacion = :proPresentacion")})
public class TblProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID_PRODUCTO")
    private Integer proIdProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRO_NOMBRE_PRODUCTO")
    private String proNombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_PRECIO_UNITARIO")
    private float proPrecioUnitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PRO_DESCRIPCION_PRODUCTO")
    private String proDescripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRO_PRESENTACION")
    private String proPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblProducto")
    private Collection<TblResumenproducto> tblResumenproductoCollection;
    @JoinColumn(name = "PRO_ID_MARCA_FK", referencedColumnName = "MAR_ID_MARCA")
    @ManyToOne(optional = false)
    private TblMarcas proIdMarcaFk;

    public TblProducto() {
    }

    public TblProducto(Integer proIdProducto) {
        this.proIdProducto = proIdProducto;
    }

    public TblProducto(Integer proIdProducto, String proNombreProducto, float proPrecioUnitario, String proDescripcionProducto, String proPresentacion) {
        this.proIdProducto = proIdProducto;
        this.proNombreProducto = proNombreProducto;
        this.proPrecioUnitario = proPrecioUnitario;
        this.proDescripcionProducto = proDescripcionProducto;
        this.proPresentacion = proPresentacion;
    }

    public Integer getProIdProducto() {
        return proIdProducto;
    }

    public void setProIdProducto(Integer proIdProducto) {
        this.proIdProducto = proIdProducto;
    }

    public String getProNombreProducto() {
        return proNombreProducto;
    }

    public void setProNombreProducto(String proNombreProducto) {
        this.proNombreProducto = proNombreProducto;
    }

    public float getProPrecioUnitario() {
        return proPrecioUnitario;
    }

    public void setProPrecioUnitario(float proPrecioUnitario) {
        this.proPrecioUnitario = proPrecioUnitario;
    }

    public String getProDescripcionProducto() {
        return proDescripcionProducto;
    }

    public void setProDescripcionProducto(String proDescripcionProducto) {
        this.proDescripcionProducto = proDescripcionProducto;
    }

    public String getProPresentacion() {
        return proPresentacion;
    }

    public void setProPresentacion(String proPresentacion) {
        this.proPresentacion = proPresentacion;
    }

    @XmlTransient
    public Collection<TblResumenproducto> getTblResumenproductoCollection() {
        return tblResumenproductoCollection;
    }

    public void setTblResumenproductoCollection(Collection<TblResumenproducto> tblResumenproductoCollection) {
        this.tblResumenproductoCollection = tblResumenproductoCollection;
    }

    public TblMarcas getProIdMarcaFk() {
        return proIdMarcaFk;
    }

    public void setProIdMarcaFk(TblMarcas proIdMarcaFk) {
        this.proIdMarcaFk = proIdMarcaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proIdProducto != null ? proIdProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProducto)) {
            return false;
        }
        TblProducto other = (TblProducto) object;
        if ((this.proIdProducto == null && other.proIdProducto != null) || (this.proIdProducto != null && !this.proIdProducto.equals(other.proIdProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblProducto[ proIdProducto=" + proIdProducto + " ]";
    }
    
}
