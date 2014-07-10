package moncommerce.service.impl.gestionFournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionFournisseur.BonentreeProduitService;
import moncommerce.domain.model.test.BonentreeProduit;
import moncommerce.domain.model.test.BonentreeProduitPK;
import moncommerce.repositroy.gestionFournisseur.BonentreeProduitFacade;
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
