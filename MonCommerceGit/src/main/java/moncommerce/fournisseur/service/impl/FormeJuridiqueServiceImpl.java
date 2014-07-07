package moncommerce.fournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.fournisseur.service.FormeJuridiqueService;
import moncommerce.fournisseur.domain.model.FormeJuridique;
import moncommerce.fournisseur.repositroy.FormeJuridiqueFacade;
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
