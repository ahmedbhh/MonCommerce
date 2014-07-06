package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ProduitDepotService;
import moncommerce.domain.model.ProduitDepot;
import moncommerce.domain.model.ProduitDepotPK;
import moncommerce.repositroy.ProduitDepotFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProduitDepotServiceImpl
        extends AbstractServiceImpl<ProduitDepot, ProduitDepotPK>
        implements ProduitDepotService {

    @Resource
    ProduitDepotFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
