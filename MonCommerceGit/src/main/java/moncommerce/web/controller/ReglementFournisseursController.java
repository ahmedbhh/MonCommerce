package moncommerce.web.controller;

import moncommerce.domain.model.ReglementFournisseurs;
import moncommerce.repositroy.ReglementFournisseursFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "reglementFournisseursController")
@ViewScoped
public class ReglementFournisseursController extends AbstractController<ReglementFournisseurs> implements Serializable {

    @EJB
    private ReglementFournisseursFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ReglementFournisseursController() {
        super(ReglementFournisseurs.class);
    }

}
