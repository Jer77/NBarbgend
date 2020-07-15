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
public class TblDocumentosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DOC_ID_DOCUMENTO")
    private int docIdDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOC_ID_USUARIO_FK")
    private int docIdUsuarioFk;

    public TblDocumentosPK() {
    }

    public TblDocumentosPK(int docIdDocumento, int docIdUsuarioFk) {
        this.docIdDocumento = docIdDocumento;
        this.docIdUsuarioFk = docIdUsuarioFk;
    }

    public int getDocIdDocumento() {
        return docIdDocumento;
    }

    public void setDocIdDocumento(int docIdDocumento) {
        this.docIdDocumento = docIdDocumento;
    }

    public int getDocIdUsuarioFk() {
        return docIdUsuarioFk;
    }

    public void setDocIdUsuarioFk(int docIdUsuarioFk) {
        this.docIdUsuarioFk = docIdUsuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) docIdDocumento;
        hash += (int) docIdUsuarioFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDocumentosPK)) {
            return false;
        }
        TblDocumentosPK other = (TblDocumentosPK) object;
        if (this.docIdDocumento != other.docIdDocumento) {
            return false;
        }
        if (this.docIdUsuarioFk != other.docIdUsuarioFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.barbgend.entities.TblDocumentosPK[ docIdDocumento=" + docIdDocumento + ", docIdUsuarioFk=" + docIdUsuarioFk + " ]";
    }
    
}
