/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.gestionFournisseur;

import moncommerce.domain.model.gestionFournisseur.ReglementFournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ReglementFournisseursFacade extends JpaRepository<ReglementFournisseurs,Long> {
    
}
