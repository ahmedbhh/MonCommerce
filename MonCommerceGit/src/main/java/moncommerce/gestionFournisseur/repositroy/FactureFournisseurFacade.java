/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionFournisseur.repositroy;

import moncommerce.gestionFournisseur.domain.model.FactureFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface FactureFournisseurFacade extends JpaRepository<FactureFournisseur,Long> {
    
}
