package moncommerce.web.controller;

import moncommerce.domain.model.ContactFournisseurs;
import moncommerce.repositroy.ContactFournisseursFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "contactFournisseursController")
@ViewScoped
public class ContactFournisseursController extends AbstractController<ContactFournisseurs> implements Serializable {

    @EJB
    private ContactFournisseursFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ContactFournisseursController() {
        super(ContactFournisseurs.class);
    }

}
