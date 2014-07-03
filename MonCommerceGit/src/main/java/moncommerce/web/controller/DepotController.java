package moncommerce.web.controller;

import moncommerce.domain.model.Depot;
import moncommerce.repositroy.DepotFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "depotController")
@ViewScoped
public class DepotController extends AbstractController<Depot> implements Serializable {

    @EJB
    private DepotFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public DepotController() {
        super(Depot.class);
    }

}
