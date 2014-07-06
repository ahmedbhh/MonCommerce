package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.SousfamilleService;
import moncommerce.domain.model.Sousfamille;
import moncommerce.repositroy.SousfamilleFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class SousfamilleServiceImpl
        extends AbstractServiceImpl<Sousfamille, String>
        implements SousfamilleService {

    @Resource
    SousfamilleFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
