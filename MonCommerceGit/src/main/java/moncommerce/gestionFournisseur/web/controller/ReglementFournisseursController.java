package moncommerce.gestionFournisseur.web.controller;

import moncommerce.gestionFournisseur.domain.model.ReglementFournisseurs;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.gestionFournisseur.service.ReglementFournisseursService;
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
