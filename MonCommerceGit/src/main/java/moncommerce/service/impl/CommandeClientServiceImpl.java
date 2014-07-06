package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.CommandeClient;
import moncommerce.repositroy.CommandeClientFacade;
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
