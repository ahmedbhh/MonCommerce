/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.produit;

import moncommerce.domain.model.produit.Uniteemesure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface UniteemesureFacade extends JpaRepository<Uniteemesure,Long> {
    
}