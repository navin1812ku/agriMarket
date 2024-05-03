package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.search.RetailerIdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailerIdProfileSearchServiceImpl implements RetailerIdProfileSearchService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Override
    public Object retailerIdSearch(String retailerId) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Given ID: "+retailerId+" has no account");
            return response;
        }
        else {
            return retailerModel;
        }
    }
}
