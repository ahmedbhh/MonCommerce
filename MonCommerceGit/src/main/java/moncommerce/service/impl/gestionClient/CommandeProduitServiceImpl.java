package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.gestionFournisseur.CommandeProduit;
import moncommerce.domain.model.gestionFournisseur.CommandeProduitPK;
import moncommerce.repositroy.gestionFournisseur.CommandeProduitFacade;
import moncommerce.service.gestionClient.CommandeProduitService;
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
public class CommandeProduitServiceImpl
        extends AbstractServiceImpl<CommandeProduit, CommandeProduitPK>
        implements CommandeProduitService {

    @Resource
    CommandeProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
