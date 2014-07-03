package moncommerce.web.controller;

import moncommerce.domain.model.Uniteemesure;
import moncommerce.repositroy.UniteemesureFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "uniteemesureController")
@ViewScoped
public class UniteemesureController extends AbstractController<Uniteemesure> implements Serializable {

    @EJB
    private UniteemesureFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public UniteemesureController() {
        super(Uniteemesure.class);
    }

}
