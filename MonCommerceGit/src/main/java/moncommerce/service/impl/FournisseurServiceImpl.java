package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.FournisseurService;
import moncommerce.domain.model.Fournisseur;
import moncommerce.repositroy.FournisseurFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FournisseurServiceImpl
        extends AbstractServiceImpl<Fournisseur, Long>
        implements FournisseurService {

    @Resource
    FournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
