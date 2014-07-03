package moncommerce.web.controller;

import moncommerce.domain.model.ProduitCodeTarif;
import moncommerce.repositroy.ProduitCodeTarifFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produitCodeTarifController")
@ViewScoped
public class ProduitCodeTarifController extends AbstractController<ProduitCodeTarif> implements Serializable {

    @EJB
    private ProduitCodeTarifFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitCodeTarifController() {
        super(ProduitCodeTarif.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitCodeTarifPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getProduitCodeTarifPK().setIDCodetarif(this.getSelected().getCodeTarif().getIDCodetarif());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitCodeTarifPK(new moncommerce.domain.model.ProduitCodeTarifPK());
    }

}
