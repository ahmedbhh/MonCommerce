package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.test.FactureClientProduit;
import moncommerce.domain.model.test.FactureClientProduitPK;
import moncommerce.repositroy.gestionClient.FactureClientProduitFacade;
import moncommerce.service.gestionClient.FactureClientProduitService;
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
public class FactureClientProduitServiceImpl
        extends AbstractServiceImpl<FactureClientProduit, FactureClientProduitPK>
        implements FactureClientProduitService {

    @Resource
    FactureClientProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
    @Override
    public void remove(FactureClientProduitPK entity) {
        repository.delete(entity);
    }
}
