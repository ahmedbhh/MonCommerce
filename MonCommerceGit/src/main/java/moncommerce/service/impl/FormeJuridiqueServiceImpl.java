package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.FormeJuridiqueService;
import moncommerce.domain.model.FormeJuridique;
import moncommerce.repositroy.FormeJuridiqueFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FormeJuridiqueServiceImpl
        extends AbstractServiceImpl<FormeJuridique, Long>
        implements FormeJuridiqueService {

    @Resource
    FormeJuridiqueFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
