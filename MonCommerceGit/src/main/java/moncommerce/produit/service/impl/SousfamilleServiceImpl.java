package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.service.SousfamilleService;
import moncommerce.produit.domain.model.Sousfamille;
import moncommerce.produit.repositroy.SousfamilleFacade;
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
