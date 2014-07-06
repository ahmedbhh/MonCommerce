package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ModeTvaService;
import moncommerce.domain.model.ModeTva;
import moncommerce.repositroy.ModeTvaFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ModeTvaServiceImpl extends AbstractServiceImpl<ModeTva,Long> implements ModeTvaService {

    @Resource
    ModeTvaFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
