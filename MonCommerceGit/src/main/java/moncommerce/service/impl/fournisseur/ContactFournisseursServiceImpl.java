package moncommerce.service.impl.fournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.fournisseur.ContactFournisseursService;
import moncommerce.domain.model.test.ContactFournisseurs;
import moncommerce.repositroy.fournisseur.ContactFournisseursFacade;
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
