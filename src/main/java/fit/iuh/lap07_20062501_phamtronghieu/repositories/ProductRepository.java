package fit.iuh.lap07_20062501_phamtronghieu.repositories;

import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

     public abstract void deleteById(Long id);

     public abstract Product findById(long id);






}