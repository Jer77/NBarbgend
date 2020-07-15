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
@Table(name = "tbl_marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMarcas.findAll", query = "SELECT t FROM TblMarcas t")
    , @NamedQuery(name = "TblMarcas.findByMarIdMarca", query = "SELECT t FROM TblMarcas t WHERE t.marIdMarca = :marIdMarca")
    , @NamedQuery(name = "TblMarcas.findByMarNombreMarca", query = "SELECT t FROM TblMarcas t WHERE t.marNombreMarca = :marNombreMarca")})
public class TblMarcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAR_ID_MARCA")
    private Integer marIdMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MAR_NOMBRE_MARCA")
    private String marNombreMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proIdMarcaFk")
    private Collection<TblProducto> tblProductoCollection;

    public TblMarcas() {
    }

    public TblMarcas(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public TblMarcas(Integer marIdMarca, String marNombreMarca) {
        this.marIdMarca = marIdMarca;
        this.marNombreMarca = marNombreMarca;
    }

    public Integer getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public String getMarNombreMarca() {
        return marNombreMarca;
    }

    public void setMarNombreMarca(String marNombreMarca) {
        this.marNombreMarca = marNombreMarca;
    }

    @XmlTransient
    public Collection<TblProducto> getTblProductoCollection() {
        return tblProductoCollection;
    }

    public void setTblProductoCollection(Collection<TblProducto> tblProductoCollection) {
        this.tblProductoCollection = tblProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marIdMarca != null ? marIdMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMarcas)) {
            return false;
        }
        TblMarcas other = (TblMarcas) object;
        if ((this.marIdMarca == null && other.marIdMarca != null) || (this.marIdMarca != null && !this.marIdMarca.equals(other.marIdMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblMarcas[ marIdMarca=" + marIdMarca + " ]";
    }
    
}
