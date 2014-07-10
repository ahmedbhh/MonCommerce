package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionClient.ReglementClientService;
import moncommerce.domain.model.test.ReglementClient;
import moncommerce.repositroy.gestionClient.ReglementClientFacade;
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
