package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.search.SearchRetailerByAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchRetailerByAddressServiceImpl implements SearchRetailerByAddressService {

    @Autowired
    private RetailerRepository retailerRepository;


    @Override
    public Object searchRetailerByAddress(String location) {
        List<RetailerModel> retailerModels=retailerRepository.findByRetailerAddress(location);
        if(retailerModels==null){
            Response response=new Response();
            response.setMessage("Given location: "+location+" has no retailers");
            return response;
        }
        else {
            return retailerModels;
        }
    }
}
