package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.gestionClient.Caisse;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.CaisseService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "caisseController")
@ViewScoped
public class CaisseController extends AbstractController<Caisse> implements Serializable {

    @Autowired
    private CaisseService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CaisseController() {
        super(Caisse.class);
    }

}
