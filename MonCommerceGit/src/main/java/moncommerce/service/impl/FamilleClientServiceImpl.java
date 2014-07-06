package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.FamilleClient;
import moncommerce.repositroy.FamilleClientFacade;
import moncommerce.service.FamilleClientService;
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
