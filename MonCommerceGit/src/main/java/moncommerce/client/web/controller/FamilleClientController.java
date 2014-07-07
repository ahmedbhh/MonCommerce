package moncommerce.client.web.controller;

import moncommerce.client.domain.model.FamilleClient;
import moncommerce.client.repositroy.FamilleClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.client.service.FamilleClientService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "familleClientController")
@ViewScoped
public class FamilleClientController extends AbstractController<FamilleClient> implements Serializable {

    @Autowired
    private FamilleClientService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleClientController() {
        super(FamilleClient.class);
    }

}
