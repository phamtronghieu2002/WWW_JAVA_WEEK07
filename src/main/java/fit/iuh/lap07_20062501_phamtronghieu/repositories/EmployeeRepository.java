package fit.iuh.lap07_20062501_phamtronghieu.repositories;

import fit.iuh.lap07_20062501_phamtronghieu.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}