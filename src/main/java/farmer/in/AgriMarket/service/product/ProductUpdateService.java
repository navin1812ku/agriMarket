package farmer.in.AgriMarket.service.product;

import farmer.in.AgriMarket.dto.product.ProductUpdateRequest;

public interface ProductUpdateService {
    Object updateProduct(Long productId, ProductUpdateRequest productUpdateRequest);
}
