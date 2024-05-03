package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerProfileViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerProfileViewServiceImpl implements FarmerProfileViewService {

    @Autowired
    private FarmerRepository farmerRepository;
    @Override
    public Object getProfile(String farmerId) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            return farmerModel;
        }
    }
}
