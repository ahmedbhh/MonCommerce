package moncommerce.web.converter.gestionClient;

import moncommerce.domain.model.test.BondesortieProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.gestionClient.BondesortieProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class BondesortieProduitConverter implements Converter {

    @Autowired
    private BondesortieProduitService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.test.BondesortieProduitPK getKey(String value) {
        moncommerce.domain.model.test.BondesortieProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.test.BondesortieProduitPK();
        key.setIdProduit(Long.parseLong(values[0]));
        key.setIDBondesortie(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.test.BondesortieProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdProduit());
        sb.append(SEPARATOR);
        sb.append(value.getIDBondesortie());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof BondesortieProduit) {
            BondesortieProduit o = (BondesortieProduit) object;
            return getStringKey(o.getBondesortieProduitPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BondesortieProduit.class.getName()});
            return null;
        }
    }

}
