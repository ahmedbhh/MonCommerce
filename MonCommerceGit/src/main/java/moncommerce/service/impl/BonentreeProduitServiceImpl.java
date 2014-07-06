package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.BonentreeProduitService;
import moncommerce.domain.model.BonentreeProduit;
import moncommerce.domain.model.BonentreeProduitPK;
import moncommerce.repositroy.BonentreeProduitFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BonentreeProduitServiceImpl
        extends AbstractServiceImpl<BonentreeProduit,BonentreeProduitPK>
        implements BonentreeProduitService {
    
    @Resource
    BonentreeProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
