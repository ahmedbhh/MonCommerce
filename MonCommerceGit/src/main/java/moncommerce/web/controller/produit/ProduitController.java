package moncommerce.web.controller.produit;

import moncommerce.domain.model.produit.Produit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.ProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "produitController")
@ViewScoped
public class ProduitController extends AbstractController<Produit> implements Serializable {

    @Autowired
    private ProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitController() {
        super(Produit.class);
    }

}
