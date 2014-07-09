package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.produit.SousfamilleService;
import moncommerce.domain.model.produit.Sousfamille;
import moncommerce.repositroy.produit.SousfamilleFacade;
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
