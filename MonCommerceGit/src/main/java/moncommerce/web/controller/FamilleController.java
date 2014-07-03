package moncommerce.web.controller;

import moncommerce.domain.model.Famille;
import moncommerce.repositroy.FamilleFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "familleController")
@ViewScoped
public class FamilleController extends AbstractController<Famille> implements Serializable {

    @EJB
    private FamilleFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleController() {
        super(Famille.class);
    }

}
