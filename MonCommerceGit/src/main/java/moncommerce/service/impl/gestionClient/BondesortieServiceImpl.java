package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.gestionClient.Bondesortie;
import moncommerce.repositroy.gestionClient.BondesortieFacade;
import moncommerce.repositroy.EntrpriseFacade;
import moncommerce.service.gestionClient.BondesortieService;
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
