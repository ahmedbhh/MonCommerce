package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.test.FactureFournisseur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.FactureFournisseurService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "factureFournisseurController")
@ViewScoped
public class FactureFournisseurController extends AbstractController<FactureFournisseur> implements Serializable {

    @Autowired
    private FactureFournisseurService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureFournisseurController() {
        super(FactureFournisseur.class);
    }

}
