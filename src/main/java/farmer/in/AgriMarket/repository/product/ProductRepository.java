package farmer.in.AgriMarket.repository.product;

import farmer.in.AgriMarket.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    ProductModel findByProductId(Long productId);

    List<ProductModel> findByProductName(String productName);

    @Query("SELECT p FROM ProductModel p WHERE p.productCost >= :initialValue AND p.productCost <= :finalValue")
    List<ProductModel> findByProductByPrice(@Param("initialValue") Double initialValue, @Param("finalValue") Double finalValue);
}
