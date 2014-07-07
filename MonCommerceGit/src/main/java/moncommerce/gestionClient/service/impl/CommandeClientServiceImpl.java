package moncommerce.gestionClient.service.impl;

import moncommerce.gestionClient.service.CommandeClientService;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.gestionClient.domain.model.CommandeClient;
import moncommerce.gestionClient.repositroy.CommandeClientFacade;
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
public class CommandeClientServiceImpl
        extends AbstractServiceImpl<CommandeClient, Long> implements CommandeClientService {

    @Resource
    CommandeClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
