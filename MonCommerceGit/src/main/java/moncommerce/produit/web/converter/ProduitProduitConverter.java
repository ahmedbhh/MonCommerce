package moncommerce.produit.web.converter;

import moncommerce.domain.model.produit.ProduitProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.produit.ProduitProduitService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class ProduitProduitConverter implements Converter {

    @Autowired
    private ProduitProduitService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.produit.ProduitProduitPK getKey(String value) {
        moncommerce.domain.model.produit.ProduitProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.produit.ProduitProduitPK();
        key.setIDProduitComposant(Long.parseLong(values[0]));
        key.setIDProduitComposee(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.produit.ProduitProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDProduitComposant());
        sb.append(SEPARATOR);
        sb.append(value.getIDProduitComposee());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ProduitProduit) {
            ProduitProduit o = (ProduitProduit) object;
            return getStringKey(o.getProduitProduitPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProduitProduit.class.getName()});
            return null;
        }
    }

}
