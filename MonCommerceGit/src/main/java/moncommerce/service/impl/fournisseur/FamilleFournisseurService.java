package moncommerce.service.impl.fournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.test.FamilleFournisseur;
import moncommerce.repositroy.fournisseur.FamilleFournisseurFacade;
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
public class FamilleFournisseurService extends AbstractServiceImpl<FamilleFournisseur, Long> implements moncommerce.service.fournisseur.FamilleFournisseurService {

    @Resource
    FamilleFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
