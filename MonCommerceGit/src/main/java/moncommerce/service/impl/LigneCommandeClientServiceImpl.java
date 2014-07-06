package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.LigneCommandeClientService;
import moncommerce.domain.model.LigneCommandeClient;
import moncommerce.domain.model.LigneCommandeClientPK;
import moncommerce.repositroy.LigneCommandeClientFacade;
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
