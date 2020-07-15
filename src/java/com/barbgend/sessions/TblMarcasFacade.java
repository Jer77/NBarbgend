/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.sessions;

import com.barbgend.entities.TblMarcas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yenni rosalba
 */
@Stateless
public class TblMarcasFacade extends AbstractFacade<TblMarcas> {

    @PersistenceContext(unitName = "BarbgendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMarcasFacade() {
        super(TblMarcas.class);
    }
    
}
