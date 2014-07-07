/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.domain.model.BondesortieProduit;
import moncommerce.gestionClient.domain.model.BondesortieProduitPK;
import moncommerce.gestionClient.repositroy.BondesortieProduitFacade;
import moncommerce.gestionClient.service.BondesortieProduitService;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service

public class BondesortieProduitServiceImpl extends AbstractServiceImpl<BondesortieProduit,BondesortieProduitPK> implements BondesortieProduitService {

    @Resource
    BondesortieProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
