package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.test.Bonentree;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.BonentreeService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "bonentreeController")
@ViewScoped
public class BonentreeController extends AbstractController<Bonentree> implements Serializable {

    @Autowired
    private BonentreeService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BonentreeController() {
        super(Bonentree.class);
    }

}
