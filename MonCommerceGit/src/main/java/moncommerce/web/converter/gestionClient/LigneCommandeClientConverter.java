package moncommerce.web.converter.gestionClient;

import moncommerce.domain.model.test.LigneCommandeClient;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.gestionClient.LigneCommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class LigneCommandeClientConverter implements Converter {

    @Autowired
    private LigneCommandeClientService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.test.LigneCommandeClientPK getKey(String value) {
        moncommerce.domain.model.test.LigneCommandeClientPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.test.LigneCommandeClientPK();
        key.setIDCommandeClient(Long.parseLong(values[0]));
        key.setIdProduit(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.test.LigneCommandeClientPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDCommandeClient());
        sb.append(SEPARATOR);
        sb.append(value.getIdProduit());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof LigneCommandeClient) {
            LigneCommandeClient o = (LigneCommandeClient) object;
            return getStringKey(o.getLigneCommandeClientPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LigneCommandeClient.class.getName()});
            return null;
        }
    }

}
