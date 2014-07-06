package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.FactureClientProduit;
import moncommerce.domain.model.FactureClientProduitPK;
import moncommerce.repositroy.FactureClientProduitFacade;
import moncommerce.service.FactureClientProduitService;
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
