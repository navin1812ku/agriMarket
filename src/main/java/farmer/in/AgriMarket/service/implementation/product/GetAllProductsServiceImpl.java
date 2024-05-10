package farmer.in.AgriMarket.service.implementation.product;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.product.GetAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class GetAllProductsServiceImpl implements GetAllProductsService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object getAllProducts() {
        List<Object> products= Collections.singletonList(productRepository.findAll());

        if(products==null){
            Response response=new Response();
            response.setMessage("Yet no product added to the sale");
            return response;
        }
        else{
            return products;
        }
    }
}
