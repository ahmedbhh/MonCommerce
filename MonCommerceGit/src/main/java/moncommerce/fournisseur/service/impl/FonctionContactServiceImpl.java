package moncommerce.fournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.fournisseur.service.FonctionContactService;
import moncommerce.fournisseur.domain.model.FonctionContact;
import moncommerce.fournisseur.repositroy.FonctionContactFacade;
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
public class FonctionContactServiceImpl extends AbstractServiceImpl<FonctionContact,Long> implements FonctionContactService{
    @Resource
    FonctionContactFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
    
}
