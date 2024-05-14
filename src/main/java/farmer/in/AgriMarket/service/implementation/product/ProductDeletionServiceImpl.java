package farmer.in.AgriMarket.service.implementation.product;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.product.ProductDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeletionServiceImpl implements ProductDeletionService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object deleteProduct(Long productId) {
        productRepository.deleteById(productId);

        ProductModel productModel=productRepository.findByProductId(productId);
        Response response=new Response();
        if(productModel==null){
            response.setMessage("Product with id: "+productId+" deleted successfully");
        }
        else{
            response.setMessage("While deleting product with id: "+productId+" there is an issue so provide the proper productId");
        }
        return response;
    }
}
