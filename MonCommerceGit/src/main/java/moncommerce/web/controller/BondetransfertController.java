package moncommerce.web.controller;

import moncommerce.domain.model.Bondetransfert;
import moncommerce.repositroy.BondetransfertFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bondetransfertController")
@ViewScoped
public class BondetransfertController extends AbstractController<Bondetransfert> implements Serializable {

    @EJB
    private BondetransfertFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondetransfertController() {
        super(Bondetransfert.class);
    }

}
