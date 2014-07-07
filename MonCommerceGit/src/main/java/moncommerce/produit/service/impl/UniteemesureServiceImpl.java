package moncommerce.produit.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.produit.domain.model.Uniteemesure;
import moncommerce.repositroy.EntrpriseFacade;
import moncommerce.produit.service.UniteemesureService;
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
