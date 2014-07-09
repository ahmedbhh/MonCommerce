package moncommerce.web.controller.produit;

import moncommerce.domain.model.produit.Sousfamille;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.SousfamilleService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "sousfamilleController")
@ViewScoped
public class SousfamilleController extends AbstractController<Sousfamille> implements Serializable {

    @Autowired
    private SousfamilleService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public SousfamilleController() {
        super(Sousfamille.class);
    }

}
