/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.produit;

import moncommerce.domain.model.test.ProduitCodeTarif;
import moncommerce.domain.model.test.ProduitCodeTarifPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ProduitCodeTarifFacade extends JpaRepository<ProduitCodeTarif,ProduitCodeTarifPK> {
    
}
