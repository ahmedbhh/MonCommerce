package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ContactService;
import moncommerce.domain.model.Contact;
import moncommerce.repositroy.ContactFacade;
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
