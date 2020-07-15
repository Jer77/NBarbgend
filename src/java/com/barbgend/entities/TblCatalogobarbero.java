/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_catalogobarbero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCatalogobarbero.findAll", query = "SELECT t FROM TblCatalogobarbero t")
    , @NamedQuery(name = "TblCatalogobarbero.findByCatIdCatalogo", query = "SELECT t FROM TblCatalogobarbero t WHERE t.catIdCatalogo = :catIdCatalogo")
    , @NamedQuery(name = "TblCatalogobarbero.findByCatFechaIngreso", query = "SELECT t FROM TblCatalogobarbero t WHERE t.catFechaIngreso = :catFechaIngreso")
    , @NamedQuery(name = "TblCatalogobarbero.findByCatDescripcion", query = "SELECT t FROM TblCatalogobarbero t WHERE t.catDescripcion = :catDescripcion")})
public class TblCatalogobarbero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAT_ID_CATALOGO")
    private Integer catIdCatalogo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAT_FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date catFechaIngreso;
    @Size(max = 300)
    @Column(name = "CAT_DESCRIPCION")
    private String catDescripcion;
    @Lob
    @Column(name = "CAT_IMG")
    private byte[] catImg;
    @JoinColumn(name = "CAT_ID_BARBERO_FK", referencedColumnName = "USU_ID_USUARIO")
    @ManyToOne(optional = false)
    private TblUsuario catIdBarberoFk;

    public TblCatalogobarbero() {
    }

    public TblCatalogobarbero(Integer catIdCatalogo) {
        this.catIdCatalogo = catIdCatalogo;
    }

    public TblCatalogobarbero(Integer catIdCatalogo, Date catFechaIngreso) {
        this.catIdCatalogo = catIdCatalogo;
        this.catFechaIngreso = catFechaIngreso;
    }

    public Integer getCatIdCatalogo() {
        return catIdCatalogo;
    }

    public void setCatIdCatalogo(Integer catIdCatalogo) {
        this.catIdCatalogo = catIdCatalogo;
    }

    public Date getCatFechaIngreso() {
        return catFechaIngreso;
    }

    public void setCatFechaIngreso(Date catFechaIngreso) {
        this.catFechaIngreso = catFechaIngreso;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }

    public byte[] getCatImg() {
        return catImg;
    }

    public void setCatImg(byte[] catImg) {
        this.catImg = catImg;
    }

    public TblUsuario getCatIdBarberoFk() {
        return catIdBarberoFk;
    }

    public void setCatIdBarberoFk(TblUsuario catIdBarberoFk) {
        this.catIdBarberoFk = catIdBarberoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catIdCatalogo != null ? catIdCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCatalogobarbero)) {
            return false;
        }
        TblCatalogobarbero other = (TblCatalogobarbero) object;
        if ((this.catIdCatalogo == null && other.catIdCatalogo != null) || (this.catIdCatalogo != null && !this.catIdCatalogo.equals(other.catIdCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblCatalogobarbero[ catIdCatalogo=" + catIdCatalogo + " ]";
    }
    
}
