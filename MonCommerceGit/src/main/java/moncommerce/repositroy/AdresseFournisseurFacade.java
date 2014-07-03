/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import moncommerce.domain.model.AdresseFournisseur;

/**
 *
 * @author AHMED
 */
@Stateless
public class AdresseFournisseurFacade extends AbstractFacade<AdresseFournisseur> {
    @PersistenceContext(unitName = "com.ppp_MonCommerceGit_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresseFournisseurFacade() {
        super(AdresseFournisseur.class);
    }
    
}
