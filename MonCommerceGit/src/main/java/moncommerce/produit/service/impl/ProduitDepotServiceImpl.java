package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.service.ProduitDepotService;
import moncommerce.produit.domain.model.ProduitDepot;
import moncommerce.produit.domain.model.ProduitDepotPK;
import moncommerce.produit.repositroy.ProduitDepotFacade;
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
