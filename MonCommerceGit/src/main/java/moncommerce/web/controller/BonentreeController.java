package moncommerce.web.controller;

import moncommerce.domain.model.Bonentree;
import moncommerce.repositroy.BonentreeFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bonentreeController")
@ViewScoped
public class BonentreeController extends AbstractController<Bonentree> implements Serializable {

    @EJB
    private BonentreeFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BonentreeController() {
        super(Bonentree.class);
    }

}
