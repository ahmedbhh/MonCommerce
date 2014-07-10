package moncommerce.service.impl.gestionFournisseur;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.service.gestionFournisseur.AccompteService;
import moncommerce.domain.model.test.Accompte;
import moncommerce.repositroy.gestionFournisseur.AccompteFacade;
import moncommerce.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccompteServiceImpl extends AbstractServiceImpl<Accompte,Long> implements AccompteService {

    @Resource
    AccompteFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
