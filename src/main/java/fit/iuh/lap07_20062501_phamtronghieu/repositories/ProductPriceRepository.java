package fit.iuh.lap07_20062501_phamtronghieu.repositories;

import fit.iuh.lap07_20062501_phamtronghieu.models.ProductPrice;
import fit.iuh.lap07_20062501_phamtronghieu.pks.ProductPricePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}