/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moncommerce.repositroy.client;

import moncommerce.domain.model.test.FamilleClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface FamilleClientFacade extends JpaRepository<FamilleClient, Long> {
}
