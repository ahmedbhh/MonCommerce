package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.DetailPaymentService;
import moncommerce.domain.model.DetailPayment;
import moncommerce.repositroy.DetailPaymentFacade;
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
