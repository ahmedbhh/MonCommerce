package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.domain.model.FactureClientProduit;
import moncommerce.gestionClient.domain.model.FactureClientProduitPK;
import moncommerce.gestionClient.repositroy.FactureClientProduitFacade;
import moncommerce.gestionClient.service.FactureClientProduitService;
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
public class FactureClientProduitServiceImpl
        extends AbstractServiceImpl<FactureClientProduit, FactureClientProduitPK>
        implements FactureClientProduitService {

    @Resource
    FactureClientProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
