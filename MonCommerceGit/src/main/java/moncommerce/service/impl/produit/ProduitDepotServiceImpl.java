package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.produit.ProduitDepotService;
import moncommerce.domain.model.test.ProduitDepot;
import moncommerce.domain.model.test.ProduitDepotPK;
import moncommerce.repositroy.produit.ProduitDepotFacade;
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
