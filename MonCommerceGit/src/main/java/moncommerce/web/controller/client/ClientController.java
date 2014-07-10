package moncommerce.web.controller.client;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.domain.model.test.Client;
import moncommerce.domain.model.test.FamilleClient;
import moncommerce.service.client.ClientService;
import moncommerce.service.client.FamilleClientService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "clientController")
@ViewScoped
public class ClientController extends AbstractController<Client> implements Serializable {

    @Autowired
    private ClientService ejbFacade;

    @Autowired
    private FamilleClientService familleFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ClientController() {
        super(Client.class);
    }

   @Override
    public void persist(PersistAction persistAction, String successMessage) {
       
        
        System.out.println("teeeeeeeeeeeeeeeeeeesssssssssssssssssssssssssst");
        FamilleClient famille=familleFacade.find(new Long(1));
        System.out.println(famille);
        
        getSelected().setNom("name");
        getSelected().setIDFamilleclient(famille);
        
        ejbFacade.edit(getSelected());
        System.out.println("ooooooooooooooooooooooooooooooooooooookkkkkkkkkkkkkkkkk");
     //   getSelected().setIDFamilleclient(familleFacade.find(new Long(1)));
       
    }
}
