package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.Bondetransfert;
import moncommerce.repositroy.BondetransfertFacade;
import moncommerce.service.BondetransfertService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service

public class BondetransfertServiceImpl
        extends AbstractServiceImpl<Bondetransfert,Long>
        implements BondetransfertService {

    @Resource
    BondetransfertFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
