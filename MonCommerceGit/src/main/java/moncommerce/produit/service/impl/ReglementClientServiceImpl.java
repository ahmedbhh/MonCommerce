package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.service.ReglementClientService;
import moncommerce.gestionClient.domain.model.ReglementClient;
import moncommerce.gestionClient.repositroy.ReglementClientFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ReglementClientServiceImpl
        extends AbstractServiceImpl<ReglementClient, Long>
        implements ReglementClientService {

    @Resource
    ReglementClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
