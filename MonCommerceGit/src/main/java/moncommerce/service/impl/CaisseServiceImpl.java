package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.Caisse;
import moncommerce.repositroy.CaisseFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class CaisseServiceImpl
        extends AbstractServiceImpl<Caisse, Long> implements CaisseService {

    @Resource
    CaisseFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
