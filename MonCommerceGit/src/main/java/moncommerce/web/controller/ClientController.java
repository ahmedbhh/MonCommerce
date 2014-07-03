package moncommerce.web.controller;

import moncommerce.domain.model.Client;
import moncommerce.repositroy.ClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "clientController")
@ViewScoped
public class ClientController extends AbstractController<Client> implements Serializable {

    @EJB
    private ClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ClientController() {
        super(Client.class);
    }

}
