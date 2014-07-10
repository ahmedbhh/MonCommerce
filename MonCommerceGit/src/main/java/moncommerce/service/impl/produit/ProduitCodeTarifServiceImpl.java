package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.produit.ProduitCodeTarifService;
import moncommerce.domain.model.test.ProduitCodeTarif;
import moncommerce.domain.model.test.ProduitCodeTarifPK;
import moncommerce.repositroy.produit.ProduitCodeTarifFacade;
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
public class ProduitCodeTarifServiceImpl
        extends AbstractServiceImpl<ProduitCodeTarif,ProduitCodeTarifPK>
        implements ProduitCodeTarifService {

    @Resource
    ProduitCodeTarifFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
