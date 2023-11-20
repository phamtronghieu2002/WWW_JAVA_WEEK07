package fit.iuh.lap07_20062501_phamtronghieu.pks;

import fit.iuh.lap07_20062501_phamtronghieu.models.Order;
import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
