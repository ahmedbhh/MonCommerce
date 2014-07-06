/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.Entrprise;
import moncommerce.repositroy.EntrpriseFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import moncommerce.service.EntrepriseService;

/**
 *
 * @author AHMED
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class EntrepriseServiceImpl
        extends AbstractServiceImpl<Entrprise,Long> implements EntrepriseService {

    @Resource
    EntrpriseFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
    /* @Override
     @Transactional
     public void create(Entrprise entity) {
     repository.save(entity);

     }

     @Override
     @Transactional
     public void edit(Entrprise entity) {
     repository.save(entity);
     }

     @Override
     @Transactional
     public void remove(Entrprise entity) {
     repository.delete(entity);
     }

     @Override
     @Transactional
     public Entrprise find(Long id) {
     return repository.findOne(id);
     }

     @Override
     @Transactional
     public List<Entrprise> findAll() {
        
     return repository.findAll();
     }

     @Override
     @Transactional
     public List<Entrprise> findRange(int[] range) {
     return repository.findAll();}

     @Override
     @Transactional
     public Long count() {
     return repository.count();
     }
     */

}
