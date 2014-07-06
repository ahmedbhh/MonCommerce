package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.ReglementFournisseursService;
import moncommerce.domain.model.ReglementFournisseurs;
import moncommerce.repositroy.ReglementFournisseursFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ReglementFournisseursServiceImpl
        extends AbstractServiceImpl<ReglementFournisseurs,Long>
        implements ReglementFournisseursService {

    @Resource
    ReglementFournisseursFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
