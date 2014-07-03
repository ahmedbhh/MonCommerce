package moncommerce.web.controller;

import moncommerce.domain.model.FormeJuridique;
import moncommerce.repositroy.FormeJuridiqueFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "formeJuridiqueController")
@ViewScoped
public class FormeJuridiqueController extends AbstractController<FormeJuridique> implements Serializable {

    @EJB
    private FormeJuridiqueFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FormeJuridiqueController() {
        super(FormeJuridique.class);
    }

}
