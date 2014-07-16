/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.gestionClient;

import moncommerce.domain.model.test.FactureClientProduit;
import moncommerce.domain.model.test.FactureClientProduitPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author AHMED
 */
public interface FactureClientProduitFacade 
    extends JpaRepository<FactureClientProduit,FactureClientProduitPK> {
    
    @Query("DELETE a FROM FactureClientProduit a WHERE a.FactureClientProduitPK = :pkfacture")
    @Override
    public void delete(@Param("pkfacture") FactureClientProduitPK pkfacture);

}
