/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionClient.repositroy;

import moncommerce.gestionClient.domain.model.CommandeProduit;
import moncommerce.gestionClient.domain.model.CommandeProduitPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface CommandeProduitFacade extends JpaRepository<CommandeProduit,CommandeProduitPK> {
   
    
}