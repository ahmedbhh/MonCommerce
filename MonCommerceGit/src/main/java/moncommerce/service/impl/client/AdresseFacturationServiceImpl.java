package moncommerce.service.impl.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.client.AdresseFacturationService;
import moncommerce.domain.model.test.AdresseFacturation;
import moncommerce.repositroy.client.AdresseFacturationFacade;
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
