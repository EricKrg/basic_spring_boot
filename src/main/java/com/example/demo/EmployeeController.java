package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<Employee>();
    EmployeeController() {
        this.employees = buildEmployees();
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return this.employees;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Employee> deleteEmployee(@PathVariable Long id) {
        for(Iterator<Employee> itr=this.employees.iterator();itr.hasNext();)
        {
            Employee emp = itr.next();
            Long inId = emp.getId();
            if(inId == (id)){
                itr.remove();
            }
        }
        return this.employees;
    }

    // mock data
    List<Employee> buildEmployees() {
        List<Employee> emps = new ArrayList<>();
        Employee emp1 = buildEmployee(1L, "Eric", 9553226588L, "eric@email.com");
        Employee emp2 = buildEmployee(2L, "Sarah", 8654782255L, "sarah@email.com");
        Employee emp3 = buildEmployee(3L, "Cool Dude", 8654782255L, "cool@email.com");
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        return emps;
    }
    Employee buildEmployee(Long id, String fname, Long phoneNo, String email) {
        Employee emp = new Employee(id, fname, phoneNo, email);
        return emp;
    }
}