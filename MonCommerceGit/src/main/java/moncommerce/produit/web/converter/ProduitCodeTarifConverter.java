package moncommerce.produit.web.converter;

import moncommerce.domain.model.test.ProduitCodeTarif;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.produit.ProduitCodeTarifService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class ProduitCodeTarifConverter implements Converter {

    @Autowired
    private ProduitCodeTarifService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.test.ProduitCodeTarifPK getKey(String value) {
        moncommerce.domain.model.test.ProduitCodeTarifPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.test.ProduitCodeTarifPK();
        key.setIDCodetarif(Long.parseLong(values[0]));
        key.setIdProduit(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.test.ProduitCodeTarifPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDCodetarif());
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
        if (object instanceof ProduitCodeTarif) {
            ProduitCodeTarif o = (ProduitCodeTarif) object;
            return getStringKey(o.getProduitCodeTarifPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProduitCodeTarif.class.getName()});
            return null;
        }
    }

}
