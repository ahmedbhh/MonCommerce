package moncommerce.client.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.client.service.ModeTvaService;
import moncommerce.client.domain.model.ModeTva;
import moncommerce.client.repositroy.ModeTvaFacade;
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
public class ModeTvaServiceImpl extends AbstractServiceImpl<ModeTva,Long> implements ModeTvaService {

    @Resource
    ModeTvaFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
