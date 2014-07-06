package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ProduitCodeTarifService;
import moncommerce.domain.model.ProduitCodeTarif;
import moncommerce.domain.model.ProduitCodeTarifPK;
import moncommerce.repositroy.ProduitCodeTarifFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ProduitCodeTarifServiceImpl
        extends AbstractServiceImpl<ProduitCodeTarif,ProduitCodeTarifPK>
        implements ProduitCodeTarifService {

    @Resource
    ProduitCodeTarifFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
