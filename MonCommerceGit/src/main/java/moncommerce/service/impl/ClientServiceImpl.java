package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.Client;
import moncommerce.repositroy.ClientFacade;
import moncommerce.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ClientServiceImpl
        extends AbstractServiceImpl<Client, Long> implements ClientService {

    @Resource
    ClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
