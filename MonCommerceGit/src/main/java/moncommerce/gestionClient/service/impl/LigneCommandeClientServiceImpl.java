package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.service.LigneCommandeClientService;
import moncommerce.gestionClient.domain.model.LigneCommandeClient;
import moncommerce.gestionClient.domain.model.LigneCommandeClientPK;
import moncommerce.gestionClient.repositroy.LigneCommandeClientFacade;
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
