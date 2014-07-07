package moncommerce.gestionClient.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.gestionClient.service.DetailPaymentService;
import moncommerce.gestionClient.domain.model.DetailPayment;
import moncommerce.gestionClient.repositroy.DetailPaymentFacade;
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
