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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yenni rosalba
 */
@Entity
@Table(name = "tbl_usorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsorol.findAll", query = "SELECT t FROM TblUsorol t")
    , @NamedQuery(name = "TblUsorol.findByUsrlIdUsuariorol", query = "SELECT t FROM TblUsorol t WHERE t.usrlIdUsuariorol = :usrlIdUsuariorol")
    , @NamedQuery(name = "TblUsorol.findByUsrlFechaIngreso", query = "SELECT t FROM TblUsorol t WHERE t.usrlFechaIngreso = :usrlFechaIngreso")})
public class TblUsorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USRL_ID_USUARIOROL")
    private Integer usrlIdUsuariorol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USRL_FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date usrlFechaIngreso;
    @JoinColumn(name = "USRL_ID_ROL_FK", referencedColumnName = "ROL_ID_ROL")
    @ManyToOne(optional = false)
    private TblRoles usrlIdRolFk;
    @JoinColumn(name = "USRL_ID_USUARIOROL", referencedColumnName = "USU_ID_USUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblUsuario tblUsuario;

    public TblUsorol() {
    }

    public TblUsorol(Integer usrlIdUsuariorol) {
        this.usrlIdUsuariorol = usrlIdUsuariorol;
    }

    public TblUsorol(Integer usrlIdUsuariorol, Date usrlFechaIngreso) {
        this.usrlIdUsuariorol = usrlIdUsuariorol;
        this.usrlFechaIngreso = usrlFechaIngreso;
    }

    public Integer getUsrlIdUsuariorol() {
        return usrlIdUsuariorol;
    }

    public void setUsrlIdUsuariorol(Integer usrlIdUsuariorol) {
        this.usrlIdUsuariorol = usrlIdUsuariorol;
    }

    public Date getUsrlFechaIngreso() {
        return usrlFechaIngreso;
    }

    public void setUsrlFechaIngreso(Date usrlFechaIngreso) {
        this.usrlFechaIngreso = usrlFechaIngreso;
    }

    public TblRoles getUsrlIdRolFk() {
        return usrlIdRolFk;
    }

    public void setUsrlIdRolFk(TblRoles usrlIdRolFk) {
        this.usrlIdRolFk = usrlIdRolFk;
    }

    public TblUsuario getTblUsuario() {
        return tblUsuario;
    }

    public void setTblUsuario(TblUsuario tblUsuario) {
        this.tblUsuario = tblUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrlIdUsuariorol != null ? usrlIdUsuariorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsorol)) {
            return false;
        }
        TblUsorol other = (TblUsorol) object;
        if ((this.usrlIdUsuariorol == null && other.usrlIdUsuariorol != null) || (this.usrlIdUsuariorol != null && !this.usrlIdUsuariorol.equals(other.usrlIdUsuariorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblUsorol[ usrlIdUsuariorol=" + usrlIdUsuariorol + " ]";
    }
    
}
