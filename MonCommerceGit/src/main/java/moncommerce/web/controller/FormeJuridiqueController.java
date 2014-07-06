package moncommerce.web.controller;

import moncommerce.domain.model.FormeJuridique;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.FormeJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "formeJuridiqueController")
@ViewScoped
public class FormeJuridiqueController extends AbstractController<FormeJuridique> implements Serializable {

    @Autowired
    private FormeJuridiqueService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FormeJuridiqueController() {
        super(FormeJuridique.class);
    }

}
