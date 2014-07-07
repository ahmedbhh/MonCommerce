package moncommerce.fournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.fournisseur.service.AdresseFournisseurService;
import moncommerce.fournisseur.domain.model.AdresseFournisseur;
import moncommerce.fournisseur.repositroy.AdresseFournisseurFacade;
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

public class AdresseFournisseurServiceImpl extends AbstractServiceImpl<AdresseFournisseur,Long> implements AdresseFournisseurService {

    @Resource
    AdresseFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
