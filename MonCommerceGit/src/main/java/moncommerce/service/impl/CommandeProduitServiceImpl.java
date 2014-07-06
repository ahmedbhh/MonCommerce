package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.CommandeProduit;
import moncommerce.domain.model.CommandeProduitPK;
import moncommerce.repositroy.CommandeProduitFacade;
import moncommerce.service.CommandeProduitService;
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
