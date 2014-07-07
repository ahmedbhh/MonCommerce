package moncommerce.gestionFournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionFournisseur.service.FactureFournisseurReglementFournisseursService;
import moncommerce.gestionFournisseur.domain.model.FactureFournisseurReglementFournisseurs;
import moncommerce.gestionFournisseur.domain.model.FactureFournisseurReglementFournisseursPK;
import moncommerce.gestionFournisseur.repositroy.FactureFournisseurReglementFournisseursFacade;
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
public class FactureFournisseurReglementFournisseursServiceImpl
        extends AbstractServiceImpl<FactureFournisseurReglementFournisseurs,FactureFournisseurReglementFournisseursPK>
        implements FactureFournisseurReglementFournisseursService {

    @Resource
    FactureFournisseurReglementFournisseursFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
