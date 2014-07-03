package moncommerce.web.controller;

import moncommerce.domain.model.Bondesortie;
import moncommerce.repositroy.BondesortieFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bondesortieController")
@ViewScoped
public class BondesortieController extends AbstractController<Bondesortie> implements Serializable {

    @EJB
    private BondesortieFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondesortieController() {
        super(Bondesortie.class);
    }

}
