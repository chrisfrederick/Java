package com.chrisfrederick.postgrescrud.repositories;

import com.chrisfrederick.postgrescrud.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
