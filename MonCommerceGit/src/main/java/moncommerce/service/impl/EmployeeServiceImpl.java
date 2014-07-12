/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import moncommerce.domain.model.test.Employee;
import moncommerce.repositroy.EmployeeFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AHMED
 */

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, Long>{
    @Resource
    EmployeeFacade repository;

    @PostConstruct
    public void init() {
        super.setJpaRepository(repository);

    }
}
