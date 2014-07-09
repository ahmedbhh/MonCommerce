package moncommerce.web.controller.fournisseur;

import moncommerce.domain.model.fournisseur.FamilleFournisseur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.fournisseur.FamilleFournisseurService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "familleFournisseurController")
@ViewScoped
public class FamilleFournisseurController extends AbstractController<FamilleFournisseur> implements Serializable {

    @Autowired
    private FamilleFournisseurService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleFournisseurController() {
        super(FamilleFournisseur.class);
    }

}
