package fit.iuh.lap07_20062501_phamtronghieu.services;


import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import fit.iuh.lap07_20062501_phamtronghieu.repositories.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productResponsitory;

        public Page<Product> findAll(int pageNo, int pageSize, String sortBy,
                                     String sortDirection) {
            Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

            return productResponsitory.findAll(pageable);
        }



//    public void add(Product p){
//        productResponsitory.save(p);
//    }
//    public void delete(long id){
//        productResponsitory.deleteById(id);
//    }
//    public Product getProductbyId(long id){
//        return productResponsitory.getReferenceById(id);
//    }
}
