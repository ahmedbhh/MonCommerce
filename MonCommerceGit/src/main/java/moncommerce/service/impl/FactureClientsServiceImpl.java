package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.FactureClientsService;
import moncommerce.domain.model.FactureClients;
import moncommerce.repositroy.EntrpriseFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FactureClientsServiceImpl
        extends AbstractServiceImpl<FactureClients, Long>
        implements FactureClientsService {

    @Resource
    EntrpriseFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
