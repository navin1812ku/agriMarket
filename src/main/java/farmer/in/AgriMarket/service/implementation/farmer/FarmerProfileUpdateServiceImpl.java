package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerProfileUpdateRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerProfileUpdateServiceImpl implements FarmerProfileUpdateService {

    @Autowired
    private FarmerRepository farmerRepository;


    @Override
    public Object updateProfile(String farmerId, FarmerProfileUpdateRequest farmerProfileUpdateRequest) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            String email=farmerProfileUpdateRequest.getEmail();
            farmerModel.setEmail(email!=null ? email:farmerModel.getEmail());

            String fullName=farmerProfileUpdateRequest.getFullName();
            farmerModel.setFullName(fullName!=null ? fullName:farmerModel.getFullName());

            String mobileNumber=farmerProfileUpdateRequest.getMobileNumber();
            farmerModel.setMobileNumber(mobileNumber!=null ? mobileNumber:farmerModel.getMobileNumber());

            String age=farmerProfileUpdateRequest.getAge();
            farmerModel.setAge(age!=null ? age:farmerModel.getAge());

            farmerRepository.save(farmerModel);

            return farmerRepository.findByFarmerId(farmerId);
        }
    }
}
