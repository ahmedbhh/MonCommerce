/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.produit.repositroy;

import moncommerce.produit.domain.model.ProduitCodeTarif;
import moncommerce.produit.domain.model.ProduitCodeTarifPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ProduitCodeTarifFacade extends JpaRepository<ProduitCodeTarif,ProduitCodeTarifPK> {
    
}
