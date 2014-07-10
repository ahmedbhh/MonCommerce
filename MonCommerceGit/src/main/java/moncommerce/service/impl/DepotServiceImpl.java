package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.DepotService;
import moncommerce.domain.model.test.Depot;
import moncommerce.repositroy.DepotFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class DepotServiceImpl extends AbstractServiceImpl<Depot,Long> implements DepotService{
    @Resource
    DepotFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
