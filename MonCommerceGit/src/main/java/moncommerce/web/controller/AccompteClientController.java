package moncommerce.web.controller;

import moncommerce.domain.model.AccompteClient;
import moncommerce.repositroy.AccompteClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "accompteClientController")
@ViewScoped
public class AccompteClientController extends AbstractController<AccompteClient> implements Serializable {

    @EJB
    private AccompteClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AccompteClientController() {
        super(AccompteClient.class);
    }

}
