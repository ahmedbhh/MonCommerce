package moncommerce.service.impl.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.client.ContactService;
import moncommerce.domain.model.client.Contact;
import moncommerce.repositroy.client.ContactFacade;
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
public class ContactServiceImpl
        extends AbstractServiceImpl<Contact, Long> implements ContactService {

    @Resource
    ContactFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
