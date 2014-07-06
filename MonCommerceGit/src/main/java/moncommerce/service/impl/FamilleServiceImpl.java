package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.FamilleService;
import moncommerce.domain.model.Famille;
import moncommerce.repositroy.FamilleFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FamilleServiceImpl extends AbstractServiceImpl<Famille,Long> implements FamilleService {

    @Resource
    FamilleFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
