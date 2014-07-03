package moncommerce.web.controller;

import moncommerce.domain.model.FactureClients;
import moncommerce.repositroy.FactureClientsFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "factureClientsController")
@ViewScoped
public class FactureClientsController extends AbstractController<FactureClients> implements Serializable {

    @EJB
    private FactureClientsFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureClientsController() {
        super(FactureClients.class);
    }

}
