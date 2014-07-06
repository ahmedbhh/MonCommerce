package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.Bondesortie;
import moncommerce.repositroy.BondesortieFacade;
import moncommerce.repositroy.EntrpriseFacade;
import moncommerce.service.BondesortieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BondesortieServiceImpl
        extends AbstractServiceImpl<Bondesortie,Long>
        implements BondesortieService {

    @Resource
    BondesortieFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
