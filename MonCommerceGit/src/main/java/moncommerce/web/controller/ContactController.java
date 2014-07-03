package moncommerce.web.controller;

import moncommerce.domain.model.Contact;
import moncommerce.repositroy.ContactFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "contactController")
@ViewScoped
public class ContactController extends AbstractController<Contact> implements Serializable {

    @EJB
    private ContactFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ContactController() {
        super(Contact.class);
    }

}
