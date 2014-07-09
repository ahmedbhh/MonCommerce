package moncommerce.service.impl.produit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.produit.Uniteemesure;
import moncommerce.repositroy.EntrpriseFacade;
import moncommerce.service.produit.UniteemesureService;
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
public class UniteemesureServiceImpl 
extends AbstractServiceImpl<Uniteemesure,Long> 
implements UniteemesureService {

    @Resource
    EntrpriseFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
