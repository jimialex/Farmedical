/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmedical.beans;

import com.farmedical.entity.Agenda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class AgendaFacade extends AbstractFacade<Agenda> {
    @PersistenceContext(unitName = "FarmedicalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgendaFacade() {
        super(Agenda.class);
    }
    
}
