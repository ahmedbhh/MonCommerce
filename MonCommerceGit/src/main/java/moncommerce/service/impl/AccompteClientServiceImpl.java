package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.AccompteClient;
import moncommerce.repositroy.AccompteClientFacade;
import moncommerce.service.AccompteClientService;
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
