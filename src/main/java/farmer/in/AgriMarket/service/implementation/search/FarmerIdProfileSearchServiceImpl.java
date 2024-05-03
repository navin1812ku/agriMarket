package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.search.FarmerIdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerIdProfileSearchServiceImpl implements FarmerIdProfileSearchService {

    @Autowired
    private FarmerRepository farmerRepository;


    @Override
    public Object farmerIdSearch(String farmerId) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Given ID: "+farmerId+" has no account");
            return response;
        }
        else {
            return farmerModel;
        }
    }
}
