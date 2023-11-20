package fit.iuh.lap07_20062501_phamtronghieu.repositories;

import fit.iuh.lap07_20062501_phamtronghieu.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}