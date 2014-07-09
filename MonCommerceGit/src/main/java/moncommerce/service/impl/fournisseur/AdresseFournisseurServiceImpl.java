package moncommerce.service.impl.fournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.fournisseur.AdresseFournisseurService;
import moncommerce.domain.model.fournisseur.AdresseFournisseur;
import moncommerce.repositroy.fournisseur.AdresseFournisseurFacade;
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
