package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.gestionClient.AccompteClient;
import moncommerce.repositroy.gestionClient.AccompteClientFacade;
import moncommerce.service.gestionClient.AccompteClientService;
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
