/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy.gestionClient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import moncommerce.domain.model.gestionClient.DetailPayment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */

public interface DetailPaymentFacade extends JpaRepository<DetailPayment,Long> {
    
}