package moncommerce.client.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.client.domain.model.Client;
import moncommerce.client.repositroy.ClientFacade;
import moncommerce.client.service.ClientService;
import moncommerce.service.impl.AbstractServiceImpl;
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
