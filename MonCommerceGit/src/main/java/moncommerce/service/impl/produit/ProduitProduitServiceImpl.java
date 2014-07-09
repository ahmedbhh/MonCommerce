package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.produit.ProduitProduit;
import moncommerce.domain.model.produit.ProduitProduitPK;
import moncommerce.repositroy.produit.ProduitProduitFacade;
import moncommerce.service.produit.ProduitProduitService;
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
