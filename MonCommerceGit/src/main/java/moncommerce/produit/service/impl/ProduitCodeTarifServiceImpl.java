package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.service.ProduitCodeTarifService;
import moncommerce.produit.domain.model.ProduitCodeTarif;
import moncommerce.produit.domain.model.ProduitCodeTarifPK;
import moncommerce.produit.repositroy.ProduitCodeTarifFacade;
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
