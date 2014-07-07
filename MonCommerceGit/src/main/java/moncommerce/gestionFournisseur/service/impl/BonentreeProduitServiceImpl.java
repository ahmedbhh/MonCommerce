package moncommerce.gestionFournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionFournisseur.service.BonentreeProduitService;
import moncommerce.gestionFournisseur.domain.model.BonentreeProduit;
import moncommerce.gestionFournisseur.domain.model.BonentreeProduitPK;
import moncommerce.gestionFournisseur.repositroy.BonentreeProduitFacade;
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
