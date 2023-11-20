package fit.iuh.lap07_20062501_phamtronghieu.pks;


import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter @Getter
public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime price_date_time;
}
