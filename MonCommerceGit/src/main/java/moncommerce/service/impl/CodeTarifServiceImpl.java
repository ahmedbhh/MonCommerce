package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.*;
import moncommerce.domain.model.CodeTarif;
import moncommerce.repositroy.CodeTarifFacade;
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
