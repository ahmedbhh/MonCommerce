/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.gestionClient.BondesortieProduit;
import moncommerce.domain.model.gestionClient.BondesortieProduitPK;
import moncommerce.repositroy.gestionClient.BondesortieProduitFacade;
import moncommerce.service.gestionClient.BondesortieProduitService;
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
