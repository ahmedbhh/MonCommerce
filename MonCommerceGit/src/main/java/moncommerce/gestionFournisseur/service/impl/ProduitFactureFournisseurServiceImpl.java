package moncommerce.gestionFournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionFournisseur.service.ProduitFactureFournisseurService;
import moncommerce.gestionFournisseur.domain.model.ProduitFactureFournisseur;
import moncommerce.gestionFournisseur.domain.model.ProduitFactureFournisseurPK;
import moncommerce.gestionFournisseur.repositroy.ProduitFactureFournisseurFacade;
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
