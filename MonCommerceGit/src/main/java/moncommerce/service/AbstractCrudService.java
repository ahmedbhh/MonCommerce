/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moncommerce.service;

import java.util.Collection;

/**
 *
 * @author AHMED
 * @param <T>
 */
public interface AbstractCrudService<T,ID> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public T find(ID id);

    public Collection<T> findAll();

    public Collection<T> findRange(int[] range);

    public Long count();

}
