package farmer.in.AgriMarket.repository.product;

import farmer.in.AgriMarket.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    ProductModel findByProductId(Long productId);

    List<ProductModel> findByProductName(String productName);
}
