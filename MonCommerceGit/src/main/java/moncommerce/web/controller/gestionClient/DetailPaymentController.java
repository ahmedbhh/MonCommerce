package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.test.DetailPayment;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.DetailPaymentService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "detailPaymentController")
@ViewScoped
public class DetailPaymentController extends AbstractController<DetailPayment> implements Serializable {

    @Autowired
    private DetailPaymentService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public DetailPaymentController() {
        super(DetailPayment.class);
    }

}
