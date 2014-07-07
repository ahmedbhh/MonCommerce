package moncommerce.client.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.client.service.AdresseFacturationService;
import moncommerce.client.domain.model.AdresseFacturation;
import moncommerce.client.repositroy.AdresseFacturationFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "adresseFacturationServiceImpl")
public class AdresseFacturationServiceImpl extends AbstractServiceImpl<AdresseFacturation,Long> implements AdresseFacturationService{
       @Resource
       AdresseFacturationFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
