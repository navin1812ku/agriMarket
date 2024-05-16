package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.search.SearchProductByPriceRequest;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.search.SearchProductByPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchProductByPriceServiceImpl implements SearchProductByPriceService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object searchProductByPrice(SearchProductByPriceRequest searchProductByPriceRequest) {
        Double initialValue= searchProductByPriceRequest.getInitialValue();
        Double finalValue= searchProductByPriceRequest.getFinalValue();

        List<ProductModel> productList=productRepository.findByProductByPrice(initialValue, finalValue);

        if(productList.size()==0){
            Response response=new Response();
            response.setMessage("Product not available");
            return response;
        }
        else{
            return productList;
        }
    }
}
