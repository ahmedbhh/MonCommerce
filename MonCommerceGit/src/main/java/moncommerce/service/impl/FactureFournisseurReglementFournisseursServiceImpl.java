package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.FactureFournisseurReglementFournisseursService;
import moncommerce.domain.model.FactureFournisseurReglementFournisseurs;
import moncommerce.domain.model.FactureFournisseurReglementFournisseursPK;
import moncommerce.repositroy.FactureFournisseurReglementFournisseursFacade;
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
