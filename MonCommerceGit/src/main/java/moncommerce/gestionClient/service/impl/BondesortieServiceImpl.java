package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.domain.model.Bondesortie;
import moncommerce.gestionClient.repositroy.BondesortieFacade;
import moncommerce.repositroy.EntrpriseFacade;
import moncommerce.gestionClient.service.BondesortieService;
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
public class BondesortieServiceImpl
        extends AbstractServiceImpl<Bondesortie,Long>
        implements BondesortieService {

    @Resource
    BondesortieFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
