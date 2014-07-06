package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ProduitService;
import moncommerce.domain.model.Produit;
import moncommerce.repositroy.ProduitFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProduitServiceImpl
        extends AbstractServiceImpl<Produit, Long>
        implements ProduitService {

    @Resource
    ProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
