package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.Bonentree;
import moncommerce.repositroy.BonentreeFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BonentreeServiceImpl
        extends AbstractServiceImpl<Bonentree, Long> implements BonentreeService {

    @Resource
    BonentreeFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
