package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.AdresseFournisseurService;
import moncommerce.domain.model.AdresseFournisseur;
import moncommerce.repositroy.AdresseFournisseurFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service

public class AdresseFournisseurServiceImpl extends AbstractServiceImpl<AdresseFournisseur,Long> implements AdresseFournisseurService {

    @Resource
    AdresseFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
