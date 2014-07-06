package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ProduitFactureFournisseurService;
import moncommerce.domain.model.ProduitFactureFournisseur;
import moncommerce.domain.model.ProduitFactureFournisseurPK;
import moncommerce.repositroy.ProduitFactureFournisseurFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProduitFactureFournisseurServiceImpl
        extends AbstractServiceImpl<ProduitFactureFournisseur,ProduitFactureFournisseurPK>
        implements ProduitFactureFournisseurService {

    @Resource
    ProduitFactureFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
