package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ModeDeReglementService;
import moncommerce.domain.model.test.ModeDeReglement;
import moncommerce.repositroy.ModeDeReglementFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ModeDeReglementServiceImpl
        extends AbstractServiceImpl<ModeDeReglement, Long>
        implements ModeDeReglementService {

    @Resource
    ModeDeReglementFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
