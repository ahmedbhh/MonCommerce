package moncommerce.service.impl.fournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.fournisseur.FormeJuridiqueService;
import moncommerce.domain.model.fournisseur.FormeJuridique;
import moncommerce.repositroy.fournisseur.FormeJuridiqueFacade;
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
