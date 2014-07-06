package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.TvaService;
import moncommerce.domain.model.Tva;
import moncommerce.repositroy.TvaFacade;
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
