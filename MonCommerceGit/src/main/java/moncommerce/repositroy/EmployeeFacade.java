/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.repositroy;

import moncommerce.domain.model.test.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AHMED
 */
public interface EmployeeFacade  extends JpaRepository<Employee,Long> {
    
}
