package moncommerce.web.controller;

import moncommerce.domain.model.Sousfamille;
import moncommerce.repositroy.SousfamilleFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "sousfamilleController")
@ViewScoped
public class SousfamilleController extends AbstractController<Sousfamille> implements Serializable {

    @EJB
    private SousfamilleFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public SousfamilleController() {
        super(Sousfamille.class);
    }

}
