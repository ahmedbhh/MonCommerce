package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.AdresseFacturationService;
import moncommerce.domain.model.AdresseFacturation;
import moncommerce.repositroy.AdresseFacturationFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AdresseFacturationServiceImpl extends AbstractServiceImpl<AdresseFacturation,Long> implements AdresseFacturationService{
       @Resource
       AdresseFacturationFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
