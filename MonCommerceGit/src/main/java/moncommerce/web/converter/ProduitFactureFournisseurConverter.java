package moncommerce.web.converter;

import moncommerce.domain.model.ProduitFactureFournisseur;
import moncommerce.repositroy.ProduitFactureFournisseurFacade;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class ProduitFactureFournisseurConverter implements Converter {

    @EJB
    private ProduitFactureFournisseurFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.ProduitFactureFournisseurPK getKey(String value) {
        moncommerce.domain.model.ProduitFactureFournisseurPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.ProduitFactureFournisseurPK();
        key.setIDFactureFournisseur(Long.parseLong(values[0]));
        key.setIDProduit(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.ProduitFactureFournisseurPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDFactureFournisseur());
        sb.append(SEPARATOR);
        sb.append(value.getIDProduit());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ProduitFactureFournisseur) {
            ProduitFactureFournisseur o = (ProduitFactureFournisseur) object;
            return getStringKey(o.getProduitFactureFournisseurPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProduitFactureFournisseur.class.getName()});
            return null;
        }
    }

}
