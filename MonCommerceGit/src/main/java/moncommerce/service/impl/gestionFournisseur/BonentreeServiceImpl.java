package moncommerce.service.impl.gestionFournisseur;

import moncommerce.service.gestionFournisseur.BonentreeService;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.test.Bonentree;
import moncommerce.repositroy.gestionFournisseur.BonentreeFacade;
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
public class BonentreeServiceImpl
        extends AbstractServiceImpl<Bonentree, Long> implements BonentreeService {

    @Resource
    BonentreeFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
