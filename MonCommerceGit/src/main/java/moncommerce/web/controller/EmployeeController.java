/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.web.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.domain.model.test.Employee;
import moncommerce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author AHMED
 */

@Controller
@ManagedBean
@ViewScoped
public class EmployeeController extends AbstractController<Employee> implements Serializable {
    @Autowired
    private EmployeeService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EmployeeController() {
        super(Employee.class);
    }
    
}
