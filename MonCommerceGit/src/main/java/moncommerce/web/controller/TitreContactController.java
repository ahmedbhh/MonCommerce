package moncommerce.web.controller;

import moncommerce.domain.model.TitreContact;
import moncommerce.repositroy.TitreContactFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "titreContactController")
@ViewScoped
public class TitreContactController extends AbstractController<TitreContact> implements Serializable {

    @EJB
    private TitreContactFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TitreContactController() {
        super(TitreContact.class);
    }

}
