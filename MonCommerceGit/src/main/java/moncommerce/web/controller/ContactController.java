package moncommerce.web.controller;

import moncommerce.domain.model.Contact;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "contactController")
@ViewScoped
public class ContactController extends AbstractController<Contact> implements Serializable {

    @Autowired
    private ContactService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ContactController() {
        super(Contact.class);
    }

}
