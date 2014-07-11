package moncommerce.web.converter;

import moncommerce.domain.model.test.BondetransfertProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.BondetransfertProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@ManagedBean
public class BondetransfertProduitConverter implements Converter {

    @Autowired
    private BondetransfertProduitService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.test.BondetransfertProduitPK getKey(String value) {
        moncommerce.domain.model.test.BondetransfertProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.test.BondetransfertProduitPK();
        key.setIdProduit(Long.parseLong(values[0]));
        key.setIDBonDeTransfert(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.test.BondetransfertProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdProduit());
        sb.append(SEPARATOR);
        sb.append(value.getIDBonDeTransfert());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof BondetransfertProduit) {
            BondetransfertProduit o = (BondetransfertProduit) object;
            return getStringKey(o.getBondetransfertProduitPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BondetransfertProduit.class.getName()});
            return null;
        }
    }

}
