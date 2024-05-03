package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.RetailerProfileUpdateRequest;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailerProfileUpdateServiceImpl implements RetailerProfileUpdateService {

    @Autowired
    private RetailerRepository retailerRepository;
    @Override
    public Object updateProfile(String retailerId, RetailerProfileUpdateRequest retailerProfileUpdateRequest) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            String email=retailerProfileUpdateRequest.getEmail();
            retailerModel.setEmail(email!=null ? email:retailerModel.getEmail());

            String fullName=retailerProfileUpdateRequest.getFullName();
            retailerModel.setFullName(fullName!=null ? fullName:retailerModel.getFullName());

            String mobileNumber=retailerProfileUpdateRequest.getMobileNumber();
            retailerModel.setMobileNumber(mobileNumber!=null ? mobileNumber:retailerModel.getMobileNumber());

            String age=retailerProfileUpdateRequest.getAge();
            retailerModel.setAge(age!=null ? age:retailerModel.getAge());

            retailerRepository.save(retailerModel);

            return retailerRepository.findByRetailerId(retailerId);
        }
    }
}
