/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.beans;

import com.farmedical.entity.MotivoPermiso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class MotivoPermisoFacade extends AbstractFacade<MotivoPermiso> {
    @PersistenceContext(unitName = "FarmedicalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivoPermisoFacade() {
        super(MotivoPermiso.class);
    }
    
}
