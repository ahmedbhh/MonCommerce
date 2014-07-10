package moncommerce.service.impl.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.test.FamilleClient;
import moncommerce.repositroy.client.FamilleClientFacade;
import moncommerce.service.client.FamilleClientService;
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

public class FamilleClientServiceImpl
        extends AbstractServiceImpl<FamilleClient, Long>
        implements FamilleClientService {

    @Resource
    FamilleClientFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
