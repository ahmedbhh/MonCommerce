package moncommerce.web.controller;

import moncommerce.domain.model.FonctionContact;
import moncommerce.repositroy.FonctionContactFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "fonctionContactController")
@ViewScoped
public class FonctionContactController extends AbstractController<FonctionContact> implements Serializable {

    @EJB
    private FonctionContactFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FonctionContactController() {
        super(FonctionContact.class);
    }

}
