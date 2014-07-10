package moncommerce.service.impl.gestionFournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionFournisseur.ProduitFactureFournisseurService;
import moncommerce.domain.model.test.ProduitFactureFournisseur;
import moncommerce.domain.model.test.ProduitFactureFournisseurPK;
import moncommerce.repositroy.gestionFournisseur.ProduitFactureFournisseurFacade;
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
