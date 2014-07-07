package moncommerce.produit.service.impl;

import moncommerce.produit.service.CodeTarifService;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.produit.domain.model.CodeTarif;
import moncommerce.produit.repositroy.CodeTarifFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class CodeTarifServiceImpl
        extends AbstractServiceImpl<CodeTarif, Long> implements CodeTarifService {

    @Resource
    CodeTarifFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }

}
