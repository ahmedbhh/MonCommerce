package moncommerce.client.web.controller;

import moncommerce.client.domain.model.Contact;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.client.service.ContactService;
import moncommerce.web.controller.AbstractController;
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
