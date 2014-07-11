package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.produit.FamilleService;
import moncommerce.domain.model.test.Famille;
import moncommerce.repositroy.produit.FamilleFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class FamilleServiceImpl extends AbstractServiceImpl<Famille,Long> implements FamilleService {

    @Resource
    FamilleFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
