package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionClient.FactureClientsService;
import moncommerce.domain.model.test.FactureClients;
import moncommerce.repositroy.gestionClient.FactureClientsFacade;
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
public class FactureClientsServiceImpl
        extends AbstractServiceImpl<FactureClients, Long>
        implements FactureClientsService {

    @Resource
    FactureClientsFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
    
}
