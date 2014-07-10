package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.test.BondetransfertProduit;
import moncommerce.domain.model.test.BondetransfertProduitPK;
import moncommerce.repositroy.BondetransfertProduitFacade;

import moncommerce.service.BondetransfertProduitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service

public class BondetransfertProduitServiceImpl
        extends AbstractServiceImpl<BondetransfertProduit,BondetransfertProduitPK>
        implements BondetransfertProduitService {

    @Resource
    BondetransfertProduitFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
