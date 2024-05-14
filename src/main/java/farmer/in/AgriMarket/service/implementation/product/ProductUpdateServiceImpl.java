package farmer.in.AgriMarket.service.implementation.product;

import farmer.in.AgriMarket.dto.product.ProductUpdateRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.product.ProductUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdateServiceImpl implements ProductUpdateService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object updateProduct(Long productId, ProductUpdateRequest productUpdateRequest) {
        ProductModel productModel=productRepository.findByProductId(productId);
        if(productModel==null){
            Response response=new Response();
            response.setMessage("Provided productID: "+productId+" does not exists");
            return response;
        }
        else{
            String productImage= productUpdateRequest.getProductImage();
            productModel.setProductImage(productImage==null ? productModel.getProductImage() : productImage);

            String productName=productUpdateRequest.getProductName();
            productModel.setProductName(productName==null ? productModel.getProductName() : productName);

            String productDescription=productUpdateRequest.getProductDescription();
            productModel.setProductDescription(productDescription==null ? productModel.getProductDescription() : productDescription);

            Integer productQuantityPerKG= productUpdateRequest.getProductQuantityPerKG();
            productModel.setProductQuantityPerKG(productQuantityPerKG==null ? productModel.getProductQuantityPerKG() : productQuantityPerKG);

            Double productCost= productUpdateRequest.getProductCost();
            productModel.setProductCost(productCost==null ? productModel.getProductCost() : productCost);

            productRepository.save(productModel);

            return productRepository.findByProductId(productId);
        }
    }
}
