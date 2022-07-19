package by.svistunovvv.restfullApp.repository;

import by.svistunovvv.restfullApp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
