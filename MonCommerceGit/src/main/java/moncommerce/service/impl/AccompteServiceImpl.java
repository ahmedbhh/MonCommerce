package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.AccompteService;
import moncommerce.domain.model.Accompte;
import moncommerce.repositroy.AccompteFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccompteServiceImpl extends AbstractServiceImpl<Accompte,Long> implements AccompteService {

    @Resource
    AccompteFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
