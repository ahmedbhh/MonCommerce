package moncommerce.service.impl.gestionClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionClient.DetailPaymentService;
import moncommerce.domain.model.test.DetailPayment;
import moncommerce.repositroy.gestionClient.DetailPaymentFacade;
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
public class DetailPaymentServiceImpl
        extends AbstractServiceImpl<DetailPayment, Long> implements DetailPaymentService {

    @Resource
    DetailPaymentFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
