package moncommerce.produit.web.controller;

import moncommerce.produit.domain.model.Famille;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.produit.service.FamilleService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "familleController")
@ViewScoped
public class FamilleController extends AbstractController<Famille> implements Serializable {

    @Autowired
    private FamilleService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleController() {
        super(Famille.class);
    }

}
