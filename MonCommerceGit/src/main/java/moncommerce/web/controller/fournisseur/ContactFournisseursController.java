package moncommerce.web.controller.fournisseur;

import moncommerce.domain.model.fournisseur.ContactFournisseurs;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.fournisseur.ContactFournisseursService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "contactFournisseursController")
@ViewScoped
public class ContactFournisseursController extends AbstractController<ContactFournisseurs> implements Serializable {

    @Autowired
    private ContactFournisseursService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ContactFournisseursController() {
        super(ContactFournisseurs.class);
    }

}
