package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ContactFournisseursService;
import moncommerce.domain.model.ContactFournisseurs;
import moncommerce.repositroy.ContactFournisseursFacade;
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
