package moncommerce.web.controller.fournisseur;

import moncommerce.domain.model.fournisseur.FonctionContact;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.fournisseur.FonctionContactService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "fonctionContactController")
@ViewScoped
public class FonctionContactController extends AbstractController<FonctionContact> implements Serializable {

    @Autowired
    private FonctionContactService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FonctionContactController() {
        super(FonctionContact.class);
    }

}
