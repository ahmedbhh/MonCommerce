package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.FamilleFournisseur;
import moncommerce.repositroy.FamilleFournisseurFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FamilleFournisseurService extends AbstractServiceImpl<FamilleFournisseur, Long> implements moncommerce.service.FamilleFournisseurService {

    @Resource
    FamilleFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
