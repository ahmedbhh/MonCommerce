package moncommerce.web.controller.client;

import moncommerce.domain.model.client.AdresseFacturation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.client.AdresseFacturationService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "adresseFacturationController")
@ViewScoped
public class AdresseFacturationController extends AbstractController<AdresseFacturation> implements Serializable {

    @Autowired
    private AdresseFacturationService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AdresseFacturationController() {
        super(AdresseFacturation.class);
    }

}
