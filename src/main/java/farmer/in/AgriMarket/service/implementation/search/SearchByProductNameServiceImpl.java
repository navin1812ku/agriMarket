package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.search.SearchByProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchByProductNameServiceImpl implements SearchByProductNameService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object searchByProductName(String productName) {
        List<ProductModel> productModelList=productRepository.findByProductName(productName);
        if(productModelList.size()==0){
            Response response=new Response();
            response.setMessage("Requested product name: "+productName+" doesn't have an product from any former");
            return response;
        }
        else {
            return productModelList;
        }
    }
}
