package moncommerce.service.impl.produit;

import moncommerce.service.produit.CodeTarifService;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.produit.CodeTarif;
import moncommerce.repositroy.produit.CodeTarifFacade;
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
