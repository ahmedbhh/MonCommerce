package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.domain.model.CommandeProduit;
import moncommerce.gestionClient.domain.model.CommandeProduitPK;
import moncommerce.gestionClient.repositroy.CommandeProduitFacade;
import moncommerce.gestionClient.service.CommandeProduitService;
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
