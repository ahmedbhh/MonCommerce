package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.gestionFournisseur.Accompte;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.AccompteService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "accompteController")
@ViewScoped
public class AccompteController extends AbstractController<Accompte> implements Serializable {

    
    @Autowired
    private AccompteService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AccompteController() {
        super(Accompte.class);
    }

}
