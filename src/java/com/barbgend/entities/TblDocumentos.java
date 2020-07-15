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
@Table(name = "tbl_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDocumentos.findAll", query = "SELECT t FROM TblDocumentos t")
    , @NamedQuery(name = "TblDocumentos.findByDocIdDocumento", query = "SELECT t FROM TblDocumentos t WHERE t.tblDocumentosPK.docIdDocumento = :docIdDocumento")
    , @NamedQuery(name = "TblDocumentos.findByDocIdUsuarioFk", query = "SELECT t FROM TblDocumentos t WHERE t.tblDocumentosPK.docIdUsuarioFk = :docIdUsuarioFk")
    , @NamedQuery(name = "TblDocumentos.findByDocTipoDocumento", query = "SELECT t FROM TblDocumentos t WHERE t.docTipoDocumento = :docTipoDocumento")})
public class TblDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDocumentosPK tblDocumentosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DOC_TIPO_DOCUMENTO")
    private String docTipoDocumento;
    @JoinColumn(name = "DOC_ID_USUARIO_FK", referencedColumnName = "USU_ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblUsuario tblUsuario;

    public TblDocumentos() {
    }

    public TblDocumentos(TblDocumentosPK tblDocumentosPK) {
        this.tblDocumentosPK = tblDocumentosPK;
    }

    public TblDocumentos(TblDocumentosPK tblDocumentosPK, String docTipoDocumento) {
        this.tblDocumentosPK = tblDocumentosPK;
        this.docTipoDocumento = docTipoDocumento;
    }

    public TblDocumentos(int docIdDocumento, int docIdUsuarioFk) {
        this.tblDocumentosPK = new TblDocumentosPK(docIdDocumento, docIdUsuarioFk);
    }

    public TblDocumentosPK getTblDocumentosPK() {
        return tblDocumentosPK;
    }

    public void setTblDocumentosPK(TblDocumentosPK tblDocumentosPK) {
        this.tblDocumentosPK = tblDocumentosPK;
    }

    public String getDocTipoDocumento() {
        return docTipoDocumento;
    }

    public void setDocTipoDocumento(String docTipoDocumento) {
        this.docTipoDocumento = docTipoDocumento;
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
        hash += (tblDocumentosPK != null ? tblDocumentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDocumentos)) {
            return false;
        }
        TblDocumentos other = (TblDocumentos) object;
        if ((this.tblDocumentosPK == null && other.tblDocumentosPK != null) || (this.tblDocumentosPK != null && !this.tblDocumentosPK.equals(other.tblDocumentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblDocumentos[ tblDocumentosPK=" + tblDocumentosPK + " ]";
    }
    
}
