package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.ProduitProduit;
import moncommerce.domain.model.ProduitProduitPK;
import moncommerce.repositroy.ProduitProduitFacade;
import moncommerce.service.ProduitProduitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProduitProduitServiceImpl
        extends AbstractServiceImpl<ProduitProduit, ProduitProduitPK>
        implements ProduitProduitService {
    
    @Resource
    ProduitProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
