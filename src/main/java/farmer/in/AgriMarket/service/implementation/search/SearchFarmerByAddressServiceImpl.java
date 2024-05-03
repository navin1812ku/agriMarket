package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.search.SearchFarmerByAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFarmerByAddressServiceImpl implements SearchFarmerByAddressService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Object searchFarmerByAddress(String location) {
        List<FarmerModel> farmerModels=farmerRepository.findByFarmerAddress(location);
        if(farmerModels==null){
            Response response=new Response();
            response.setMessage("Given location: "+location+" has no farmers");
            return response;
        }
        else {
            return farmerModels;
        }
    }
}
