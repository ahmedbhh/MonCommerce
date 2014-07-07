package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.domain.model.AccompteClient;
import moncommerce.gestionClient.repositroy.AccompteClientFacade;
import moncommerce.gestionClient.service.AccompteClientService;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccompteClientServiceImpl extends AbstractServiceImpl<AccompteClient,Long> implements AccompteClientService{
    @Resource
    AccompteClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
