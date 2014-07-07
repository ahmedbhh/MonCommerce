package moncommerce.gestionFournisseur.service.impl;

import moncommerce.gestionFournisseur.service.CommandeService;
import moncommerce.gestionFournisseur.domain.model.Commande;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionFournisseur.repositroy.CommandeFacade;
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
