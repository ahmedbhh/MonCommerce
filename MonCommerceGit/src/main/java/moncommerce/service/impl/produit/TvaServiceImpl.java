package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.produit.TvaService;
import moncommerce.domain.model.test.Tva;
import moncommerce.repositroy.produit.TvaFacade;
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
public class TvaServiceImpl
        extends AbstractServiceImpl<Tva, Long>
        implements TvaService {

    @Resource
    TvaFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
