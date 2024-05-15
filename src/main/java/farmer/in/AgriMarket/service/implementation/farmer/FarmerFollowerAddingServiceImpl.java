package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerFollowerRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerFollowers;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerFollowersRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerFollowerAddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerFollowerAddingServiceImpl implements FarmerFollowerAddingService {

    @Autowired
    private FarmerFollowersRepository farmerFollowersRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Object addFollowerToFarmer(FarmerFollowerRequest farmerFollowerRequest) {

        String farmerId= farmerFollowerRequest.getFarmerId();
        String id=farmerFollowerRequest.getId();
        Boolean isYouFollowing=farmerFollowerRequest.getIsYouFollowing();

        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Provided farmerId: "+farmerId+" doesn't exists");
            return response;
        }
        else{
            FarmerFollowers farmerFollowers=new FarmerFollowers();

            farmerFollowers.setFarmerId(farmerId);
            farmerFollowers.setId(id);
            farmerFollowers.setIsYouFollowing(isYouFollowing);

            farmerFollowersRepository.save(farmerFollowers);

            return farmerModel;
        }
    }
}
