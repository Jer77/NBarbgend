/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbgend.sessions;

import com.barbgend.entities.TblResumenagendamiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yenni rosalba
 */
@Stateless
public class TblResumenagendamientoFacade extends AbstractFacade<TblResumenagendamiento> {

    @PersistenceContext(unitName = "BarbgendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblResumenagendamientoFacade() {
        super(TblResumenagendamiento.class);
    }
    
}
