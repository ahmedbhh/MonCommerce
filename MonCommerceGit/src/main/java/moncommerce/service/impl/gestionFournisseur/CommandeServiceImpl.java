package moncommerce.service.impl.gestionFournisseur;

import moncommerce.service.gestionFournisseur.CommandeService;
import moncommerce.domain.model.test.Commande;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.repositroy.gestionFournisseur.CommandeFacade;
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
public class CommandeServiceImpl extends AbstractServiceImpl<Commande, Long> implements CommandeService {

    @Resource
    CommandeFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
