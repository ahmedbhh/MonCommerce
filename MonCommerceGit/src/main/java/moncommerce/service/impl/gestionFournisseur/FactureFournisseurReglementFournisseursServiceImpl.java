package moncommerce.service.impl.gestionFournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionFournisseur.FactureFournisseurReglementFournisseursService;
import moncommerce.domain.model.gestionFournisseur.FactureFournisseurReglementFournisseurs;
import moncommerce.domain.model.gestionFournisseur.FactureFournisseurReglementFournisseursPK;
import moncommerce.repositroy.gestionFournisseur.FactureFournisseurReglementFournisseursFacade;
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
