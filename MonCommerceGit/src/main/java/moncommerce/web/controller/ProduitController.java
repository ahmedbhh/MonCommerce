package moncommerce.web.controller;

import moncommerce.domain.model.Produit;
import moncommerce.repositroy.ProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produitController")
@ViewScoped
public class ProduitController extends AbstractController<Produit> implements Serializable {

    @EJB
    private ProduitFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitController() {
        super(Produit.class);
    }

}
