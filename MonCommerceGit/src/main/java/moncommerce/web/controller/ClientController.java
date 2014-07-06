package moncommerce.web.controller;

import moncommerce.domain.model.Client;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "clientController")
@ViewScoped
public class ClientController extends AbstractController<Client> implements Serializable {

    @Autowired
    private ClientService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ClientController() {
        super(Client.class);
    }

}
