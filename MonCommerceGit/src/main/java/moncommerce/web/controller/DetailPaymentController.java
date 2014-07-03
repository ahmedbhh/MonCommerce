package moncommerce.web.controller;

import moncommerce.domain.model.DetailPayment;
import moncommerce.repositroy.DetailPaymentFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "detailPaymentController")
@ViewScoped
public class DetailPaymentController extends AbstractController<DetailPayment> implements Serializable {

    @EJB
    private DetailPaymentFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public DetailPaymentController() {
        super(DetailPayment.class);
    }

}
