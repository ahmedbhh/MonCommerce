package moncommerce.web.controller.produit;

import moncommerce.domain.model.test.Tva;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.TvaService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "tvaController")
@ViewScoped
public class TvaController extends AbstractController<Tva> implements Serializable {

    @Autowired
    private TvaService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TvaController() {
        super(Tva.class);
    }

}
