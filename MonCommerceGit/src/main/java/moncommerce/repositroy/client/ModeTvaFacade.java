/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.client;

import moncommerce.domain.model.client.ModeTva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ModeTvaFacade extends JpaRepository<ModeTva,Long> {
    
}