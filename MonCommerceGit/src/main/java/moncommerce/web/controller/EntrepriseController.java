package moncommerce.web.controller;

import moncommerce.domain.model.test.Entreprise;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "entrepriseController")
@ViewScoped
public class EntrepriseController extends AbstractController<Entreprise> implements Serializable {

    @Autowired
    private EntrepriseService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EntrepriseController() {
        super(Entreprise.class);
    }

}
