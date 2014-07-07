package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.service.ProduitService;
import moncommerce.produit.domain.model.Produit;
import moncommerce.produit.repositroy.ProduitFacade;
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
