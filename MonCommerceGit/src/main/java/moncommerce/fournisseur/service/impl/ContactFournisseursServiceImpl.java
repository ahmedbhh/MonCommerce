package moncommerce.fournisseur.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.fournisseur.service.ContactFournisseursService;
import moncommerce.fournisseur.domain.model.ContactFournisseurs;
import moncommerce.fournisseur.repositroy.ContactFournisseursFacade;
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
public class ContactFournisseursServiceImpl
        extends AbstractServiceImpl<ContactFournisseurs,Long>
        implements ContactFournisseursService {
    
      @Resource
      ContactFournisseursFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
