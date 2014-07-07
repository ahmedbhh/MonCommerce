package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.service.TvaService;
import moncommerce.produit.domain.model.Tva;
import moncommerce.produit.repositroy.TvaFacade;
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
