package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.test.ReglementFournisseurs;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.ReglementFournisseursService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "reglementFournisseursController")
@ViewScoped
public class ReglementFournisseursController extends AbstractController<ReglementFournisseurs> implements Serializable {

    @Autowired
    private ReglementFournisseursService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ReglementFournisseursController() {
        super(ReglementFournisseurs.class);
    }

}
