/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.beans;

import com.farmedical.entity.ETelefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class ETelefonoFacade extends AbstractFacade<ETelefono> {
    @PersistenceContext(unitName = "FarmedicalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ETelefonoFacade() {
        super(ETelefono.class);
    }
    
}
