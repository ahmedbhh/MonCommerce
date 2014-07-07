package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.domain.model.ProduitProduit;
import moncommerce.produit.domain.model.ProduitProduitPK;
import moncommerce.produit.repositroy.ProduitProduitFacade;
import moncommerce.produit.service.ProduitProduitService;
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
