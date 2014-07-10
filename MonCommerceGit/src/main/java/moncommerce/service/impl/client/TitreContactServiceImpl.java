package moncommerce.service.impl.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.client.TitreContactService;
import moncommerce.domain.model.test.TitreContact;
import moncommerce.repositroy.client.TitreContactFacade;
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
public class TitreContactServiceImpl
        extends AbstractServiceImpl<TitreContact, Long>
        implements TitreContactService {

    @Resource
    TitreContactFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
