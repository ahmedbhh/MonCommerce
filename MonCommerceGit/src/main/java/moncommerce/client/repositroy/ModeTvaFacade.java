/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.client.repositroy;

import moncommerce.client.domain.model.ModeTva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ModeTvaFacade extends JpaRepository<ModeTva,Long> {
    
}