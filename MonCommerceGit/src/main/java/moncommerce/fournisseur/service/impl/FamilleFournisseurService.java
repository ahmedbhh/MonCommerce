package moncommerce.fournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.fournisseur.domain.model.FamilleFournisseur;
import moncommerce.fournisseur.repositroy.FamilleFournisseurFacade;
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
public class FamilleFournisseurService extends AbstractServiceImpl<FamilleFournisseur, Long> implements moncommerce.fournisseur.service.FamilleFournisseurService {

    @Resource
    FamilleFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
