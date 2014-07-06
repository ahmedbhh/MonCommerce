package moncommerce.web.controller;

import moncommerce.domain.model.Depot;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "depotController")
@ViewScoped
public class DepotController extends AbstractController<Depot> implements Serializable {

    @Autowired
    private DepotService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public DepotController() {
        super(Depot.class);
    }

}
