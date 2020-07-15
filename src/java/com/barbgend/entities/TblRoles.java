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
@Table(name = "tbl_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoles.findAll", query = "SELECT t FROM TblRoles t")
    , @NamedQuery(name = "TblRoles.findByRolIdRol", query = "SELECT t FROM TblRoles t WHERE t.rolIdRol = :rolIdRol")
    , @NamedQuery(name = "TblRoles.findByRolNombreRol", query = "SELECT t FROM TblRoles t WHERE t.rolNombreRol = :rolNombreRol")})
public class TblRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID_ROL")
    private Integer rolIdRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROL_NOMBRE_ROL")
    private String rolNombreRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrlIdRolFk")
    private Collection<TblUsorol> tblUsorolCollection;

    public TblRoles() {
    }

    public TblRoles(Integer rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public TblRoles(Integer rolIdRol, String rolNombreRol) {
        this.rolIdRol = rolIdRol;
        this.rolNombreRol = rolNombreRol;
    }

    public Integer getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Integer rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public String getRolNombreRol() {
        return rolNombreRol;
    }

    public void setRolNombreRol(String rolNombreRol) {
        this.rolNombreRol = rolNombreRol;
    }

    @XmlTransient
    public Collection<TblUsorol> getTblUsorolCollection() {
        return tblUsorolCollection;
    }

    public void setTblUsorolCollection(Collection<TblUsorol> tblUsorolCollection) {
        this.tblUsorolCollection = tblUsorolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolIdRol != null ? rolIdRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRoles)) {
            return false;
        }
        TblRoles other = (TblRoles) object;
        if ((this.rolIdRol == null && other.rolIdRol != null) || (this.rolIdRol != null && !this.rolIdRol.equals(other.rolIdRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblRoles[ rolIdRol=" + rolIdRol + " ]";
    }
    
}
