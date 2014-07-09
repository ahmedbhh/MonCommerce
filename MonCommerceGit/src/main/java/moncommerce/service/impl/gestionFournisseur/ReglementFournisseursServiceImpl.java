package moncommerce.service.impl.gestionFournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionFournisseur.ReglementFournisseursService;
import moncommerce.domain.model.gestionFournisseur.ReglementFournisseurs;
import moncommerce.repositroy.gestionFournisseur.ReglementFournisseursFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ReglementFournisseursServiceImpl
        extends AbstractServiceImpl<ReglementFournisseurs,Long>
        implements ReglementFournisseursService {

    @Resource
    ReglementFournisseursFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
