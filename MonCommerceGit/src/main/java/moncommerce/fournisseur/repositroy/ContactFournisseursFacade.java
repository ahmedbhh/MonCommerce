/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.fournisseur.repositroy;

import moncommerce.fournisseur.domain.model.ContactFournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface ContactFournisseursFacade extends JpaRepository<ContactFournisseurs,Long> {
    }