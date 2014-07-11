/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 * @param <T>
 */


public abstract class AbstractServiceImpl<T extends Object,ID extends Serializable> {
    
    private JpaRepository repository;
    
    public JpaRepository getJpaRepository(){
        return repository;
    }
    public void setJpaRepository(JpaRepository repository){
        this.repository=repository;
    }
    
    public void create(T entity) {
        repository.save(entity);

    }

    public void edit(T entity) {
        repository.save(entity);
    }

    public void remove(T entity) {
        repository.delete(entity);
    }

    
    public T find(ID id) {
        System.out.println("find");
        System.out.println(repository.findOne(id));
        return (T) repository.findOne(id);
    }

    public List<T> findAll() {
        
        return repository.findAll();
    }

    
    public List<T> findRange(int[] range) {
        return repository.findAll();}

    public Long count() {
        return repository.count();
    }

}
