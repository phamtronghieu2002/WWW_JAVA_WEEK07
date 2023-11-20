package fit.iuh.lap07_20062501_phamtronghieu.repositories;

import fit.iuh.lap07_20062501_phamtronghieu.models.OrderDetail;
import fit.iuh.lap07_20062501_phamtronghieu.pks.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}