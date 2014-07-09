package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionClient.LigneCommandeClientService;
import moncommerce.domain.model.gestionClient.LigneCommandeClient;
import moncommerce.domain.model.gestionClient.LigneCommandeClientPK;
import moncommerce.repositroy.gestionClient.LigneCommandeClientFacade;
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
public class LigneCommandeClientServiceImpl
        extends AbstractServiceImpl<LigneCommandeClient, LigneCommandeClientPK>
        implements LigneCommandeClientService {

    @Resource
    LigneCommandeClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
