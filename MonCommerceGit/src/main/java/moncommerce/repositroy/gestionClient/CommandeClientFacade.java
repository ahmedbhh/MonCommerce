/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.gestionClient;

import moncommerce.domain.model.gestionClient.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */

public interface CommandeClientFacade extends JpaRepository<CommandeClient,Long> {
    
}