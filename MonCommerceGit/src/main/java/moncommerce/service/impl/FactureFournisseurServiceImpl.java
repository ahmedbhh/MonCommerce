package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.FactureFournisseur;
import moncommerce.repositroy.FactureFournisseurFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FactureFournisseurServiceImpl
        extends AbstractServiceImpl<FactureFournisseur,Long>
        implements FactureFournisseurService {

    @Resource
    FactureFournisseurFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
